## Introduction

For my Object-Oriented Programming coursework I was asked to design, implement, test, and document a Java program, demonstrating the use of OOP concepts in the design while also evaluating the benefits and drawbacks of OOP in development. I did this by creating a text based game called "Blessings" which is a RPG story driven text based game based in a fictional world with factions clashing in a strive for power. The main objectives of the project were to demonstrate Object-Oriented Programming principles such as inheritance, abstraction and encapsulation, implement three software design patterns, use AI tools throughout development and reflect on their use and produce documentation including a README and this report

## Analysis of AI Support in Software Development

ChatGPT (premium) by OpenAI was the AI tool used throughout this project. It was used from the very begining of development, starting with brainstorming the game concept and narrative. I worked through the project file by file, asking ChatGPT to guide me through the coding while also having it recommend some features beyond the requirements, for example the typewriter effect of the text output. These kinds of details would have been difficult to research and implement independently within the time available. ChatGPT was used to guide me in the writing of every Java file in the project, this was done by having it debug issues such as output not displaying correctly in the terminal and editing redundant code written by me that could be cleaned up and written in a much more efficient way. ChatGPT was also entirely used in the creation of the dialogue as I would tell it the main idea of the events meant to take place and it would draft multiple ideas of how the dialogue could occur. Lastly, the most significant contribution made by ChatGPT to my work was the organisation of my files. Since there were so many classes interacting with each other in terms of enemies, chapter, player, and event systems, I found the whole process of connecting all these very challenging and spent the majority of my time on this. Through ChatGPT’s contribution, it managed to organise the project into specific classes within seconds.

Analysis of AI Support for the Observer Pattern


One design pattern I used AI support for was the Observer Pattern. I did this in multiple which where as follows.

The first stage was using AI to understand the purpose of the Observer Pattern. I asked Chat gpt to explain how it works and how it could apply to a text-based Java game. This helped me understand that the pattern is useful when one part of a program needs to notify other parts about a change without being directly connected to them. In my game, this related to events such as the player taking damage, dying, or absorbing the gem.

The second stage was deciding where the pattern would fit into my project. Chat gpt suggested a structure involving a subject, an observer interface and observer classes. I then considered how this could be adapted to my game. Because the game is relatively small in the grand scheme of things, I did not want to overcomplicate the event system, so I focused on implementing it in a simple way that matched the scale of the project.

The third stage was planning the structure of the code. AI helped me identify that I would need a GameEventListener interface with an onEvent method, and an EventBus class that stores a list of listeners and notifies them when an event is published. This separated event notification logic from the main game logic, meaning the Player class did not need to directly control every class that responded to its events.

The final stage was reviewing whether the pattern was appropriate. One consideration was that for a project of this scale, simpler direct method calls might have achieved a similar result. However, implementing the Observer Pattern showed a clear design purpose and kept the codebase loosely coupled, making it easier to add new responses to events in the future without modifying the Player class itself.

Benefits of Using AI Tools

One major advantage of working with ChatGPT was the speed with which everything was done. It would not be possible to complete this project without its help in the time frame I gave myself. With ChatGPT I avoided having to spend many hours doing research and trying various things in order to find solutions. In addition to time savings, it was helpful to be able to explain ideas in plain English at any time. For example, rather than going through pages of textbooks or documentation, I could ask ChatGPT to explain areas I didn’t understand. For example, my understanding of the design patterns was not strong; using ChatGPT I was able to firstly implement them with my limited understanding but also have ChatGPT fully explain the gaps in my knowledge, allowing me to become much more confident on these topics. ChatGPT also provided suggestions and pointed out any issues while working on the program, almost as a second set of eyes for the code.

Challenges and Limitations

However, despite the advantages, utilising AI brought some problems. At times, ChatGPT had to be directed very thouroughly, as it tended to go overboard with changes I asked for, causing me to refine prompts until the output matched my expectations. In addition, ChatGPT cannot compile or execute the written code, so all bugs had to be identified during manual execution of the program. Therefore, I had to remain attentive when reviewing outputs. My biggest issue was that it acted as a double-edged sword: although without ChatGPT I would not have achieved the same level of outcome, I found that towards the end I developed a heavy reliance on it, as it could implement ideas I would not have considered in seconds. This is especially true with features such as the typewriter effect, where it was able to modify large amounts of dialogue quickly.

Overall Impact on Learning and Development

The use of AI in this project played a major role in my learning. It allowed me to engage in a task that would have been too complex to complete independently. More importantly, it enabled me to be far more ambitious than I had initially planned. I started the project late and expected to create a simple game, but as I used ChatGPT more, I continuously expanded the project. I genuinley enjoyed developing the program and believe this was largely due to working with AI throughout the process.

## Analysis of Software Patterns in the Project

Factory Pattern

The Factory Design Pattern is implemented using the EnemyFactory class, where decisions about the object creation process for the enemies were made. Certain classes are not instantiated directly but rather through the createEnemy() method, taking arguments such as "BLESSED_SOLDIER", which allows the factory to decide which enemy object to create and returns it ready to use. So now, the rest of the code doesn't need to worry about what object was really created but simply request an enemy of that particular type. The advantage of such a solution is that there is no strong dependency on concrete classes anymore.

Singleton Pattern

The singleton design pattern has been applied by using the GameManager class so rather than allowing individual parts of the program to create a separate instance, the constructor of the class has been made private, while the getInstance() method would allow accessing the single existing instance. It is ensured that every part of the program refers to the same game state (such as chapters and selected endings), rather than referring to different versions of the game state.

Observer Pattern

Use of the EventBus class and the GameEventListener interface helped the implementation of the Observer design pattern to allow various components within the application to respond to any event that occurs without having to depend on each other. When an event occurs such as the player sustaining injuries and dying, the Player class sends the information regarding the event to the EventBus. This means that all components which are listening on the EventBus get notified automatically and act accordingly. The Player does not have to know the recipient of the message and their response but just inform them about the event.

Benefits of Using Software Patterns

It was noticeable how software design patterns provided advantages to the creation of the project. First, thanks to their organisation benifits, every piece of code became much clearer, since a single pattern offered a clear solution for a specific type of problems. For instance, the Factory pattern managed all enemys through the EnemyFactory class, and thus adding a new enemy meant modifying only one class, which otherwise should have been done in each chapter. The Singleton pattern allowed us to have just one instance of the class GameManager, eliminating the possibility of differentiating between various states of the game. Finally, the Observer pattern kept classes separated from one another, avoiding possible interference between the two.

Challenges and Limitations

However, despite the numerous organizational benefits provided by design patterns, they had certain drawbacks too. The Singleton pattern made it hard to test because it involved the existence of a single instance of the GameManager class during all the tests performed and thus required to be manually reset each time to prevent it from retaining state from previous tests.The Observer pattern introduced one more level of abstraction although, for this specific case, directly calling methods gave an identical result to applying the Observer pattern.

Overall Impact on the Project

On the whole, the implementation of patterns in designing the software had a positive effect on the project. The code became very structured, with well-defined components for each of the parts of the game.It allowed the fight engine, enemy generation, game state control and the user interface to be implemented in different classes each with its own responsibilities. This helped me to implement any of these features independently of others and thus to develop an easily understandable project. If not for these patterns, the code would be a mixture of all of those elements in only a few large classes.

## Testing

Testing Approach

Tests were conducted in order to verify that all of the important aspects of the game operated successfully and also to check whether the program responded as expected depending on the decisions made by the player. The approach to testing involved both unit testing and manual testing. Unit testing allowed verification of the functionality of specific classes and methods in particular, for example the Player class, the creation of enemies and managing game states. Manual testing was also required as the program involves interaction and had to be run via the command line in order to test it effectively.

The main areas tested were:

Player health and damage calculation
Health restoration not exceeding the maximum
Gem absorption and attack power increase
Enemy creation through the factory
Singleton behaviour of GameManager
Invalid input handling in combat and dialogue choices
Both endings of the game playing through correctly
Unit Testing

A custom TestRunner class was written by chat gpt to test key parts of the program without requiring external dependencies. Tests were written for three classes — Player, EnemyFactory and GameManager.

For instance, some tests included the validation that the health is lowered correctly by the player when attacked, that the health will never be lower than zero, that the gem absorption raises the attack damage by 15 and cannot be done twice, and that the EnemyFactory provides the right enemy type for each name. The GameManager tests made sure that each call to the getInstance() method resulted in the same instance of an object.

Manual Testing

Manual testing was carried out by running the game through the command line and playing through it fully multiple times. Valid choices were tested to confirm the expected outcomes, such as combat reducing enemy health and the correct ending triggering based on the final choice.

Invalid input was also tested — for example entering a letter instead of a number when prompted for a choice. The game handled this without crashing, displaying an error message and prompting the player to try again.

Evidence of Test Results
The following log shows the output of the TestRunner, confirming all unit tests passed successfully:

Figure 1 (resources/Screenshot 2026-05-21 213355.png)

Figure 1: Unit test results showing all 24 tests passing successfully. The output confirms that all PlayerTest, EnemyFactoryTest and GameManagerTest cases passed with 0 failures, verifying that the core game classes behave correctly across all tested scenarios.

Figure 2 (resources/combat.png)

Figure 2: Combat system working correctly during gameplay. This screenshot shows the player engaging in combat, with health bars displayed for both the player and the enemy, and the choice between attacking or recovering presented correctly each turn.

Figure 3 (resources/wrong number.png)

Figure 3: Invalid input handled without the game crashing. This screenshot shows the result of entering an incorrect value when prompted for a choice. The game displays an error message and prompts the player to try again, confirming that input validation works correctly.

Figure 4 (resources/end1.png)

Figure 4: Ending A — The Reclamation. This screenshot shows the first ending playing out correctly after the player chooses to side with the King, confirming that the branching ending system works as intended.

Figure 5 (resources/end 2.png) (resources/end2pt2.png)

Figure 5: Ending B — The Liberation. These screenshots shows the second ending after the player chooses to face the King, including the King absorbing the crown fragment and the final boss fight triggering correctly.

Testing Limitations
Although testing covered the main features of the game, there were some limitations. The unit tests focused on individual classes and did not test every possible combat outcome or dialogue path. Manual testing was useful but less repeatable than fully automated testing. If the project were expanded, it would be useful to add tests covering full chapter sequences and both ending paths automatically.

## Ethical and Legal Considerations

Over-Reliance and Academic Integrity

One of the major ethical considerations with the application of any AI tool within an academic environment is that of over-reliance. This consideration kept me in mind throughout the process of completing the task as I took care not to blindly follow what was done for me but to make sure I actually knew what each line did whenever chat gpt was used to correct errors or add features I wouldnt have been able to do. The danger of over-reliance on such services can easily become apparent as one would not learn anything from blindly copying code.I honestly felt this applied to me on some parts, some features added I still dont have a clear understanding of.

Data Handling and Privacy

Issues of data handling and data protection are crucial to consider when developing applications, especially taking into account GDPR legislation. Nevertheless, concerning the present project, the issues can be considered negligible. The application does not handle any personal data whatsoever. The entire application is conducted in the terminal window; it accepts only numbered data from the user and does not save anything apart from the session that currently occurs. The game lacks any databases, accounts of users and connectivity options. Therefore, there are no problems with GDPR in relation to this particular project although it could become important if the game was extended with leaderboards, etc.

Broader Ethical and Legal Implications

There are wider considerations around the use of AI in the development of this software, including ethics and legality. For example, issues around bias are important, as AI algorithms such as ChatGPT are trained using large datasets and may reflect biases present in that data. In regards to licensing, ChatGPT is a product developed by OpenAI and was used within the scope of its licensing agreements. The code created using ChatGPT was original to this work and did not reproduce any copyrighted code. In relation to accessibility, the game created is text-based and operates in a terminal window, meaning that it should be accessible from any machine running the JDK, but may not be accessible to visually impaired individuals using screen readers. Finally, there is the larger issue of AI tools in education; while helpful, they can potentially replace the challenge of learning.

## Conclusion

The project culminated in a working text-based adventure game made in Java, showcasing object-oriented programming and three different software design patterns. Collaborating with an AI during the development of the game proved to be a useful way of fast-tracking learning while also allowing me to gain more knowledge about Java and its features, all while taking a lot less time than would otherwise have been needed. However, collaboration with an AI also proved to be a double-edged sword, with the necessity of staying actively engaged with the program being one lesson learned from the project. For example, for future projects like this, I would be sure to commit changes to GitLab regularly to track the progress of the project and try and write more of the code myself, which will help me improve my programming abilities even further.

## References

OpenAI (2026) ChatGPT [AI language model]. Available at: https://chat.openai.com