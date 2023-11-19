// Add the necessary dependencies to your build.gradle file
// implementation 'com.google.ar:core:1.27.0'

// Import necessary packages
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.core.ArCoreApk
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode

class MainActivity : AppCompatActivity() {

    private lateinit var arFragment: ArFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the ARFragment from the layout
        arFragment = supportFragmentManager.findFragmentById(R.id.arFragment) as ArFragment

        // Check if ARCore is installed on the device
        if (ArCoreApk.getInstance().checkAvailability(this) == ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE) {
            // Handle unsupported devices
            // You may want to display a message to the user or take other actions
            return
        }

        // Set tap listener on AR plane to place 3D model
        arFragment.setOnTapArPlaneListener { hitResult, _, _ ->
            placeObject(Uri.parse("path/to/your/3d/model.sfb"), hitResult.createAnchor())
        }
    }

    private fun placeObject(modelUri: Uri, anchor: Anchor) {
        // Build the ModelRenderable from the specified URI
        ModelRenderable.builder()
            .setSource(this, modelUri)
            .build()
            .thenAccept { renderable -> addNodeToScene(renderable, anchor) }
            .exceptionally { throwable ->
                // Handle any errors that may occur during model loading
                // You may want to display an error message to the user
                null
            }
    }

    private fun addNodeToScene(renderable: ModelRenderable, anchor: Anchor) {
        // Create an AnchorNode using the provided Anchor
        val anchorNode = AnchorNode(anchor)

        // Create a TransformableNode and set its renderable
        val transformableNode = TransformableNode(arFragment.transformationSystem)
        transformableNode.renderable = renderable

        // Set the parent of the TransformableNode as the AnchorNode
        transformableNode.setParent(anchorNode)

        // Add the AnchorNode to the AR scene
        arFragment.arSceneView.scene.addChild(anchorNode)

        // Select the TransformableNode, making it interactive
        transformableNode.select()
    }
}



//Explanation: This code provides a basic explanation of the major components:

//Setting up ARFragment: The onCreate method initializes the ARFragment and checks if ARCore is available on the device.

//Tap Gesture Handling: The setOnTapArPlaneListener method sets up a listener for tap gestures on the AR plane. When a tap occurs, it calls the placeObject function with the 3D model's URI and the anchor where the model should be placed.

//Loading 3D Model: The placeObject function uses the ModelRenderable builder to load the 3D model specified by the URI. If successful, it calls the addNodeToScene function with the loaded renderable and the anchor.

//Adding 3D Model to Scene: The addNodeToScene function creates an AnchorNode using the provided anchor, creates a TransformableNode with the loaded renderable, sets the parent of the TransformableNode to the AnchorNode, adds the AnchorNode to the AR scene, and selects the TransformableNode for interaction.

//Remember to replace the placeholder URI with the actual path or URI of your 3D model in Sceneform Binary (SFB) format.
