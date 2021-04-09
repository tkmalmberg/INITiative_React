# INITiative_React
 This is an application made to aid adventurers in keeping track of just how soon that troll is going to go berserk on them.

## What is Dungeons and Dragons (D&D)?
D&D is a table-top role playing game where you create unique characters, and with the help of the Dungeon Master(DM), go on fantastical adventures full of brave heroes, mighty monters, and dastardly villains. The players will play their characters, and the DM will manage the world in which they will adventure, playing the various characters and creatures the players may meet on their journey.

## Why does this exist?
Sometimes in D&D, the party of spritely adventurers may come across fiends and villains who will wish to fight them to the bitter end. While the adveturers now get to have their fun, fighting the forces of evil, the DM has to keep track of who goes when in combat. This can be tough to manage if there are a bunch of fighters, so I made this tracker to help.
 
 ---
 
## CRUD USER STORIES:
1.	As a USER, I want to create a PLAYER CHARACTER.
2.	As a USER, I want to edit the PLAYER CHARACTER that I have created. 
   *	Name
   *	Race
   *	Class
   *	Ability Scores
   *	Hit Points
3.	As a USER, I want to delete any PLAYER CHARACTERs that I have created.
4.	As a USER, I want to create custom MONSTERs to add to my encounters.
5.	As a USER, I want to edit my custom MONSTERs.
   *	Name
   *	Hit Points
   *	Ability Scores
6.	As a USER, I want to create an encounter to keep track of combat between PLAYER CHARACTERs and MONSTERs.
7.	As a USER, I want to edit the encounter that I have created.
   *	Name
   *	Combatants in the encounter
8.	As a USER, I want to delete the encounters I have created.

## COMBAT TRACKER USER STORIES:
1.	As a USER, when I view my ENCOUNTERs, the combatants are listed on the page.
2.	As a USER, I want to start the ENCOUNTER to keep track of my combat.
3.	As a USER, I want the app to highlight which combatant’s turn it is when I click start.
4.	As a USER, when I click next, I want the tracker to highlight the next combatant in the sequence.
5.	As a USER, I want the tracker to sort the list of combatants by initiative order.
6.	As a USER I want all initiative rolls to be made when I click the start button.

---

## Technical Challenges and How I'm Tackling Them

### JSON Objects
I ran into a lot of trouble with getting used to passing JSON objects between my front and back end. One time I called an instance of an Encounter, and it was an infinitely looping JSON file. The relationship between my encounter and user models was circular, resulting in an endless recursive loop! Initially,I learned how to use serializers in order to better maintain the object's data. But I also found that you can use annotations like @JsonManageReference, @JsonBackReference, and @JsonIgnore to do a similar thing just from the model classes.

### Object Management
I found that my objects behaved strangely when I tried adding them. I believe it was due to the design that the objects have a user owner, but it's not required in the model when creating the user. I decided to hold off on having any user-based functionality before getting a working application that actually does the things I want. An important lesson in just adding one thing at a time

