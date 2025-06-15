
## **Introduction to Unity

**Unity** is a powerful and versatile cross-platform game engine used to create interactive experiences, including 2D, 3D, and VR games. It provides a rich set of tools and features out-of-the-box, such as a physics engine, animation system, and much more.

Unity uses the **C\# programming language** for scripting and supports building for all major platforms, making it easy to deploy your game to a wide range of devices.

> **Note:** The properties of most objects in Unity can be viewed and modified in the **Inspector** window by simply clicking on the object.

-----

### **GameObjects and Components**

At the core of Unity are two fundamental concepts:

  * **GameObject:** The basic object in Unity. Think of it as an empty container representing a character, prop, or piece of scenery.
  * **Component:** The functional pieces that you attach to a GameObject to give it behavior and properties.

Here are the most essential components:

  * **Transform:** Every GameObject has one. It defines the object's **position**, **rotation**, and **scale**.
  * **SpriteRenderer:** Renders a 2D image (**Sprite**) to make the GameObject visible.
  * **Rigidbody2D:** Places the GameObject under the control of the 2D physics engine, allowing it to have mass, gravity, and be affected by forces.
  * **Animator:** Manages animations for a GameObject using an **Animator Controller** (a state machine that controls which animation to play and when).

-----

### **Assets: The Resources of Your Game**

**Assets** are all the files that make up your game, organized in the **Project** window.

  * **Scenes:** A container for all the GameObjects that make up a level or a screen in your game.
  * **Sprites:** The 2D image files used for characters, items, and backgrounds.
  * **Scripts:** C\# code files that define custom behaviors for your GameObjects.
  * **Prefabs:** Reusable GameObject templates. You can configure a complex GameObject (like an enemy) and save it as a Prefab to easily create many copies.

-----

### **Unity C\# Scripting Basics**

Scripts are where you bring your game to life. In Unity, every script you create is a class that inherits from `MonoBehaviour`.

#### **MonoBehaviour and Event Functions**

The `MonoBehaviour` base class provides a framework with several **event functions** that are called by the engine in a specific order. Understanding this order is key to writing effective code.

  * **`Awake()`**: Called once when the script is first loaded. Ideal for setting up references.
  * **`Start()`**: Called once before the first frame update. Ideal for initialization.
  * **`Update()`**: Called once every frame. Used for most game logic, like handling input.
  * **`FixedUpdate()`**: Called at a fixed time interval, independent of frame rate. **All physics-related code must go here.**
  * **`LateUpdate()`**: Called once per frame, after `Update()`. Often used for camera logic.

#### **Practical Code Example: A Player Controller**

Let's create a `PlayerController.cs` script. This single script will demonstrate how to handle input, move a character, interact with components, and manage animations.

Attach this script to a player GameObject that has a `Rigidbody2D`, a `SpriteRenderer`, and an `Animator` component.

```csharp
// PlayerController.cs
using UnityEngine;

// Every Unity script inherits from MonoBehaviour
public class PlayerController : MonoBehaviour
{
    // [SerializeField] makes a private variable visible in the Unity Inspector
    // This is the best way to adjust values without changing code.
    [SerializeField] private float moveSpeed = 7f;
    [SerializeField] private float jumpForce = 14f;

    // Private variables to hold references to other components
    private Rigidbody2D rb;
    private Animator animator;
    private SpriteRenderer spriteRenderer;

    // A variable to track horizontal movement input
    private float horizontalInput;

    // Awake() is called when the script instance is being loaded.
    // It's the best place to get component references.
    void Awake()
    {
        // GetComponent<T>() finds another component on the same GameObject.
        rb = GetComponent<Rigidbody2D>();
        animator = GetComponent<Animator>();
        spriteRenderer = GetComponent<SpriteRenderer>();
    }

    // Update() is called once per frame.
    // It's ideal for handling user input.
    void Update()
    {
        // Get input from the player (A/D keys or Left/Right arrows)
        horizontalInput = Input.GetAxis("Horizontal");

        // Flip the character's sprite based on movement direction
        FlipSprite();
        
        // Update the animator with the current speed to trigger the run animation
        // Mathf.Abs() returns the absolute value, so it's always positive.
        animator.SetFloat("speed", Mathf.Abs(horizontalInput));

        // Check if the jump button (Space bar) is pressed
        if (Input.GetButtonDown("Jump"))
        {
            // Apply an upward force to make the character jump
            rb.velocity = new Vector2(rb.velocity.x, jumpForce);
            animator.SetBool("isJumping", true);
        }
    }

    // FixedUpdate() is called at a fixed interval.
    // All physics-related code should be here for consistency.
    void FixedUpdate()
    {
        // Apply velocity to the Rigidbody2D to move the character horizontally
        rb.velocity = new Vector2(horizontalInput * moveSpeed, rb.velocity.y);
    }
    
    // A custom method to handle flipping the sprite
    void FlipSprite()
    {
        if (horizontalInput < 0) // Moving left
        {
            spriteRenderer.flipX = true;
        }
        else if (horizontalInput > 0) // Moving right
        {
            spriteRenderer.flipX = false;
        }
    }

    // You can also add collision checks here, for example:
    void OnCollisionEnter2D(Collision2D collision)
    {
        // Check if the player has landed on an object tagged "Ground"
        if (collision.gameObject.CompareTag("Ground"))
        {
            animator.SetBool("isJumping", false);
        }
    }
}
```

#### **How the Script Works in the Editor**

1.  **Attach the Script:** Drag the `PlayerController.cs` file from your Project window onto your Player GameObject in the Hierarchy.

2.  **Set Values in Inspector:** Because `moveSpeed` and `jumpForce` use `[SerializeField]`, you can now see them in the Inspector and change their values without touching the code.

3.  **Animator Parameters:** In your Animator Controller, you would create two parameters:

      * A **Float** named `speed`.
      * A **Bool** named `isJumping`.
      * The script updates these values, and you would use them in your Animator to create transitions between "Idle," "Run," and "Jump" animation states.

4.  **Run the Game:** Press the Play button. Your character will now move left and right, jump, and the animations will trigger accordingly, all controlled by this single script.