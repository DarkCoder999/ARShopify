# ARShopify
The challenge in bridging the gap between traditional and online shopping lies in the absence of a tangible, physical experience when purchasing products online. The inability to physically assess products, confirm their size, and compare dimensions with real-world objects has long been a significant pain point for potential online shoppers. To address this issue and attract a wider customer base, there is a crucial need for a virtual reality (VR) application that seamlessly integrates with online shopping platforms, offering users the ability to virtually try out and interact with products in a realistic, immersive environment. <br/>
This is an Android Native application to solve these problems by using the _Augmented Reality (AR) Technology_, through which we’ll target on providing customers with virtual representation analysing the product’s size, fitment, colour theme sync, etc. With the feature of trying out their products virtually through their mobile phones, the gap between the customer and the product will be minimized.
Click [here](https://drive.google.com/file/d/1LqirPYSA4JqUgt2ROEXNXmGqC4jjVolH/view?usp=sharing) for the video presentation with app demo.

## How does it work?
We used **SceneViewer**, an immersive viewer that enables 3D and AR experiences from our Android app. It lets users of our application easily preview, place, view, and interact with web-hosted 3D models in their environment. It uses **ARCore**, which is Google’s platform for building augmented reality experiences. Using different APIs, ARCore enables our application to sense its environment, understand the world and interact with information.

ARCore uses three key capabilities to integrate virtual content with the real world as seen through your phone's camera:
1. **Motion tracking** allows the phone to understand and track its position relative to the world.
2. **Environmental understanding** allows the phone to detect the size and location of all type of surfaces: horizontal, vertical and angled surfaces like the ground, a coffee table or walls.
3. **Light estimation** allows the phone to estimate the environment's current lighting conditions.

## Screenshots of the application :
<img src="https://github.com/DarkCoder999/ARShopify/assets/105630771/cb2746d2-d0de-4708-975a-1cf2a7121943" height="500"> 
<img src="https://github.com/DarkCoder999/ARShopify/assets/105630771/3cc38b57-9492-4b67-a3d2-d3d7ade26201" height="500"> <br><br>
<img src="https://github.com/DarkCoder999/ARShopify/assets/105630771/a7ca7cf1-d3de-4fd3-9347-d69229a950e5" height="300"> 
<img src="https://github.com/DarkCoder999/ARShopify/assets/105630771/38984c65-b7f2-4eea-a29a-e2c5e8d6f4f2" height="300"> <br><br> 

## Use this application : 
1) Clone the repository and import in Android Studio to see the code + build the APK.
2) Once you open the application in your mobile, you can view a list of furniture to customize your home.
3) The home page lists the furniture with images, ratings,  reviews, and delivery dates. 
4) You can view the Augmented view to visualize the furniture in real time by allowing camera access to the app
5) Point your camera towards the place you wish to picture the furniture and wait for the model to be placed.
6) You can move the virtual model by interacting with the phone screen.

```bash
git clone https://github.com/DarkCoder999/ARShopify.git
```
