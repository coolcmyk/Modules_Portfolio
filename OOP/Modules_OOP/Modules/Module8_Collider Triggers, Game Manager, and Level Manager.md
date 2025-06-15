## **Collider Triggers, Game Manager, and Level Manager**

This guide covers how to create interactions using non-physical colliders (**Triggers**) and how to manage your game's overall state and scene transitions using a **Game Manager** and **Level Manager**. These are essential patterns for building structured and scalable games.

### **1. Collider Triggers: Detecting Interaction without Collision**

In Unity, a `Collider2D` is typically used for physical collisions—making objects bounce off each other. However, if you only want to detect when one object enters the space of another without a physical impact (like walking into a portal or collecting a coin), you use a **Trigger**.

#### **Setting Up a Trigger**

To turn any `Collider2D` component into a trigger, simply check the **"Is Trigger"** box in the Inspector.

When "Is Trigger" is enabled, the collider will no longer physically stop other objects but will instead fire special event functions when another collider enters or exits its area.

#### **The `OnTriggerEnter2D` Method**

The most common trigger event is `OnTriggerEnter2D(Collider2D other)`. This method is automatically called on a script the moment another `Collider2D` enters its trigger zone. The `other` parameter gives you access to the collider of the object that entered.

#### **Example: Creating a Level Portal**

Let's create a portal that transports the player to the next level.

**Setup:**

1.  Create a "Portal" GameObject.

2.  Add a `Collider2D` component (e.g., `BoxCollider2D`) and check **"Is Trigger"**.

3.  Create a `Player` GameObject, give it a `Rigidbody2D` and a `Collider2D`.

4.  **Tag your Player:** In the Inspector for the Player, set its **Tag** to "Player". This is crucial for identifying it in code.

5.  Create and attach the following `Portal.cs` script to your Portal GameObject.

**`Portal.cs`**

```csharp
using UnityEngine;

public class Portal : MonoBehaviour
{
    [SerializeField] private string sceneToLoad; // Set this in the Inspector

    // This method is called automatically when another collider enters this trigger
    private void OnTriggerEnter2D(Collider2D other)
    {
        // Check if the object that entered has the "Player" tag
        if (other.CompareTag("Player"))
        {
            Debug.Log("Player has entered the portal!");

            // Find the GameManager and tell its LevelManager to load the next scene
            // This is how different systems communicate.
            if (GameManager.Instance != null)
            {
                GameManager.Instance.LevelManager.LoadScene(sceneToLoad);
            }
        }
    }
}
```

Now, when the Player touches the portal, the script will find your `GameManager` and ask it to load the specified scene.

-----

### **2. Game Manager: The Brain of Your Game**

A **Game Manager** is a central object responsible for managing the overall state of your game. It often uses the **Singleton Pattern**, which ensures there is only **one** instance of the `GameManager` in the entire game. It's the perfect place to manage things that need to persist between levels, like score, player lives, or references to other managers.

#### **Example: A Singleton Game Manager**

**Setup:**

1.  Create an empty GameObject in your first scene and name it "GameManager".
2.  Attach the `GameManager.cs` script below.
3.  Also, attach the `LevelManager.cs` script (from the next section) to this same GameObject.

**`GameManager.cs`**

```csharp
using UnityEngine;

public class GameManager : MonoBehaviour
{
    // The static instance of the GameManager (Singleton Pattern)
    public static GameManager Instance { get; private set; }

    // A public property to hold a reference to the LevelManager
    public LevelManager LevelManager { get; private set; }

    // Awake is called before the first frame update
    private void Awake()
    {
        // --- Singleton Pattern Implementation ---
        // If an instance already exists and it's not this one, destroy this one.
        if (Instance != null && Instance != this)
        {
            Destroy(gameObject);
            return;
        }
        // Otherwise, set this as the instance.
        Instance = this;
        // ------------------------------------

        // Find the LevelManager component on this same GameObject
        LevelManager = GetComponent<LevelManager>();

        // This prevents the GameManager object from being destroyed when a new scene loads.
        DontDestroyOnLoad(gameObject);
    }
}
```

This `GameManager` will now persist across all scenes, holding a permanent reference to your `LevelManager`.

-----

### **3. Level Manager: Handling Scene Transitions**

The **Level Manager** is a specialized object whose job is to handle loading, unloading, and transitioning between scenes (or levels). It's good practice to separate this logic from the `GameManager` to keep your code organized.

#### **Building and Managing Scenes**

Before you can load a scene via script, you must add it to the **Build Settings**.

1.  Go to **File \> Build Settings**.

2.  Drag your scene files from the Project window into the "Scenes In Build" list.

3.  Make sure they are checked and in the desired order.

#### **Example: A Scene-Loading Level Manager**

**Setup:**

1.  Attach this `LevelManager.cs` script to your "GameManager" GameObject.

**`LevelManager.cs`**

```csharp
using System.Collections;
using UnityEngine;
using UnityEngine.SceneManagement; // Required for scene management

public class LevelManager : MonoBehaviour
{
    // A public method that can be called from other scripts (like our Portal)
    public void LoadScene(string sceneName)
    {
        // Start a coroutine to handle the loading process
        StartCoroutine(LoadSceneAsync(sceneName));
    }

    // A coroutine allows us to add delays, which is great for animations or transitions
    private IEnumerator LoadSceneAsync(string sceneName)
    {
        Debug.Log("Loading scene: " + sceneName);

        // Optional: Add a delay for a fade-out effect
        yield return new WaitForSeconds(1f);

        // Load the new scene asynchronously
        SceneManager.LoadSceneAsync(sceneName);

        // Optional: After loading, you might want to reset the player's position.
        // This part would require a reference to the player.
        // For simplicity, we'll assume the player starts at a set position in the new scene.
    }
}
```

### **Putting It All Together: The Workflow**

1.  **Scene 1 ("Level1"):** Contains your `Player` (tagged "Player") and a `Portal` GameObject. The `Portal` has a `Collider2D` (as a trigger) and the `Portal.cs` script. In its Inspector, the `sceneToLoad` field is set to "Level2". The scene also has a `GameManager` object with both the `GameManager.cs` and `LevelManager.cs` scripts attached.
2.  **Scene 2 ("Level2"):** Contains the layout for your second level.
3.  **Build Settings:** Both "Level1" and "Level2" are added to the Scenes In Build.
4.  **Game Runs:**
      * The `GameManager` initializes and persists.
      * The player moves and enters the `Portal`'s trigger.
      * `OnTriggerEnter2D` in `Portal.cs` is called.
      * The script calls `GameManager.Instance.LevelManager.LoadScene("Level2")`.
      * The `LevelManager` starts its coroutine, waits one second, and then loads "Level2".
      * The `GameManager` object survives the scene change, ready to manage the next level.