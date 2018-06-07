# video_game_idea
## How It Works so Far
As of now the skeletons of the creatures and combat systems are built.  The creatures are created and call another class to randomly generate stats for them and alocate the highest scores differently depending on the creature "type".  

The battle system is very primitive at this time. It calculates physical attack damage by dividing the attacking creatures strength by the defending creatures defence then adding the str modifier.  (str/def + modifier)

There is a creature type Heiarchy that will grant specific types a 30% damage increase against their desired matchup and a 30% decrease against an undesirable matchup. (Like in pokemon water has advantage over fire etc.)

## To Do
- decide if stats should be global variables or if they should be methods in the creature class.
- Formula for health and mana: health could be the avg of str and def 
- add magic attack, perhaps add another stat called "magic defence"
- incorparate crits, crit fails and add luck into the formula 
