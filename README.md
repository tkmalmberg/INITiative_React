# INITiative_React
 Final repo (I promise) for my casy study
 
 ---
 
## CRUD USER STORIES:
1.	As a GUEST, I want to view all the Monsters.
2.	As a GUEST, I want to be able to sign up as a USER to get more access to the app.
3.	As a USER, I want to create a PLAYER CHARACTER.
4.	As a USER, I want to edit the PLAYER CHARACTER that I have created. 
   *	Name
   *	Race
   *	Class
   *	Ability Scores
   *	Hit Points
5.	As a USER, I want to delete any PLAYER CHARACTERs that I have created.
6.	As a USER, I want to create custom MONSTERs to add to my encounters.
7.	As a USER, I want to edit my custom MONSTERs.
   *	Name
   *	Hit Points
   *	Ability Scores
8.	As a USER, I want to create an encounter to keep track of combat between PLAYER CHARACTERs and MONSTERs.
9.	As a USER, I want to edit the encounter that I have created.
   *	Name
   *	Combatants in the encounter
10.	As a USER, I want to delete the encounters I have created.
11.	As an ADMIN, I want to view USER details.
   *	First Name
   *	Last Name
   *	Email
   *	Count of ENCOUNTER
   *	Count of PLAYER CHARACTER
12.	As an ADMIN, I want to create USERs.
13.	As an ADMIN, I want to delete USERs.

## COMBAT TRACKER USER STORIES:
1.	As a USER, when I view my ENCOUNTERs, the combatants are listed on the page.
2.	As a USER, I want to start the ENCOUNTER to keep track of my combat.
3.	As a USER, I want the app to highlight which combatant’s turn it is when I click start.
4.	As a USER, when I click next, I want the tracker to highlight the next combatant in the sequence.
5.	As a USER, I want the tracker to sort the list of combatants by initiative order.
6.	As a USER I want all initiative rolls to be made when I click the start button.

---

## Technical Challenges

### 1. JSON Objects
...I ran into a lot of trouble with getting used to passing JSON objects between my front and back end. One time I called an instance of an Encounter, and it was an infinitely looping JSON file. The relationship between my encounter and user models was circular, resulting in an endless recursive loop! Initially,I learned how to use serializers in order to better maintain the object's data. But I also found that you can use annotations like @JsonManageReference, @JsonBackReference, and @JsonIgnore to do a similar thing just from the model classes.

