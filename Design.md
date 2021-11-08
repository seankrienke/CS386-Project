#*1. Description*
WalkItOff is an app for those people that have a rough time waking up in the morning, this will change the way they start their day. The user will set an alarm and walk a set distance to turn off the alarm when it goes off. Location services are used to pinpoint the user's location. The app has a leveling up system that will allow users to unlock different sounds to use as new alarms. The app has a high score system so that there is some competition and motivation for all the users.

#*2. Architecture*
The WalkItOff app has two components, the MYSQL database, and the Android application. Similar to the examples given we have split these into two packages.Classes are also listed as packages within the larger packages, these represent the individual classes and their respective functions,which will help facilitate the display of the interconnectivities. The dotted lines serve to represent the individual connectivities between class packages.
![image](https://user-images.githubusercontent.com/89943041/140659914-10eb7751-8315-4787-b803-9c48740a6f98.png)



#*3. Class Diagram*

![](https://github.com/aidenhalili/CS386-Project/blob/main/Class%20Screenshot.jpg)

#*4. Sequence Diagram*
![image](https://user-images.githubusercontent.com/89943041/140682137-ae790673-6836-4059-8668-85e5a67ed923.png)
Use Case:
Adding a new alarm

Actor:
User

Description:
The User can create a new alarm once requested

Pre-Condition:
The User has recently opened the app and ready to set an alarm for the next day

Post-Condition:
The new alarm has been set and saved

Main-Flow

1.The User has requested to make a new alarm.

2.The system has opened up the prompt for the user to select Time of alarm, Alarm sound, and distance requested.

3.The User selects the time they would like for the alarm to go off.

4.The system would save the requested time.

5.The User would open up the list of sounds they can choose from.

6.The System pulls the sounds available for the user.

7.The User selects one of the sounds given to them.

8.The system saves that sound for the current alarm.

9.The User then inputs the Distance they wish to walk in order to turn alarm off.

10.The system saves that distance into the alarm.

11.The User then selects save for the system.

11.The system takes all three requested objects and combines them to finish the alarm.

12.The system closes the prompts and the alarm is ready to go off upon selected time from the User.

Alternative Flow
**. The User decides to cancel the request to set an alarm

The system would then cancel the prompt and return to previous screen


#*5. Design Patterns*


#*6. Design Principles*
