#1.1 Problem Statement
  
  * The problem of waking up affects all areas of society. The impact of which is 
  missed deadlines, poor health, lack of self-discipline, low motivation.

--------------------------------------------------------------------------------------------------------

#1.2 Product Position Statement

 * For all individuals who struggle with waking up, or desire self improvement, Walkitoff is a lifestyle app that
 improves user health, and self discipline. Unlike stock alarm apps our product ensures users rise to the occasion whatver it may be.

----------------------------------------------------------------------------------------------------------

#1.3 Value Proposition and customer segment
 
 * Walkitoff is a lifestyle app that  allows individuals who struggle with mornings, to fundamentally change how they handle beginning their day
 by utilizing location data to physically require users to get up and move.

-----------------------------------------------------------------------------------------------------------

#3 Functional requirements

**1.)** The app accepts user input for time and sound

**2.)** When the alarm sounds, it will only shut off if a certain distance is traveled.

**3.)** 500 feet is the minimum distance for the alarm to shut off, but the user can input a higher target distance.

**4.)** Every foot travelled equates to a single point, which will go towards the user's all time score.

**5.)** When a certain amount of points are accumulated, new features will become available to the user(new alarm sounds, dark mode, etc.)

**6.)** The user can also press a button to track their walking distance without having to enable an alarm

-------------------------------------------------------------------------------------------------------------

#4 Non-functional requirements

**1.)** Resource utilization - Utilizes user device's location services

**2.)** User interface aesthetics - Contains light colors which are easy on the eyes. The user can change the color scheme to suit their tastes

**3.)** User error protection - A number wheel will be used to minimize accidentally incorrect input.

**4.)** Accessibility - Contains three items in the bottom navigation bar to make it easy to navigate: Alarm, track distance only, score details, and settings.

**5.)** Availability - Will require user location services to use alarm and distance tracking feature.

**6.)** Recoverability - Regularly updates user score in server to minimize chance of losing progress.

**7.)** Confidentiality - Location services are only acquired via user consent.

-------------------------------------------------------------------------------------------------------------

#5 MVP

 *  For developing the minimal viable product for this project, we will first focus on the very foundation of this project: the alarm. When launching the app, the user should be able to give the app permission
to access location services. The user will then be able to manually set an alarm. The user can select the time via a timepicker wheel. When the selected time arrives, the alarm will sound repeatedly until a minimum distance
of 500 feet is travelled. After that, the total distance travelled is sent to add to the users score. The MVP will have one new alarm sound and one new theme to unlock in order to demonstrate the progression system.
 
---------------------------------------------------------------------------------------------------------------

#6 Use Cases

**1.)** ![use case diagram](https://user-images.githubusercontent.com/71902318/134839863-7eaf3f85-66e7-4672-9304-ab1356dd31f1.PNG)


**2.)** 

Use Case: Set Alarm Sound
Actor: User 
Description: User sets a sound to use for when the alarm clock goes off 
Precondition: User is on the settings section of the app 
Post-condition: Alarm sound is set to selected audio 
Main flow:
1. User click on settings.
2. Click on "set alarm sound". 
3. Click on each sound to sample it.
4. Click on "choose sound" to select sound.
Alternative flows:
1. App is closed out.
2. User goes back to main screen of app. 

Use Case: Set Distance
Actor: User 
Description: User sets distance for user to travel in order to turn off the alarm.
Precondition: User is on the settings section of the app 
Post-condition: Distance is set 
Main flow:
1. User click on settings.
2. Click on "set distance". 
3. Type in numerical value for distance, and choose "ft", "mi", or "yd" for a unit of measurement. 
Alternative flows:
1. App is closed out.
2. User goes back to main screen of app. 

Use Case: Set Alarm Clock
Actor: User 
Description: User sets time for alarm clock to sound.
Precondition: User is on the settings section of the app 
Post-condition: Alarm is set
Main flow:
1. User click on settings.
2. Click on "set alarm". 
3. Type in time in numerical value and choose "AM" or "PM".
Alternative flows:
1. App is closed out.
2. User goes back to main screen of app. 

Use Case: Delete Alarm
Actor: User 
Description: User deletes the set time for the alarm to go off. 
Precondition: User is on the settings section of the app 
Post-condition: Alarm is deleted 
Main flow:
1. User click on settings.
2. Click on "delete alarm". 
Alternatives flows: 
4. App is closed out.
5. User goes back to main screen of app. 

Use Case: Set Goal
Actor: User 
Description: User sets a goal for how far they want to move. An achievement could be unlocked by meeting this distance. 
Precondition: User is on the settings section of the app 
Post-condition: Goal is set 
Main flow:
1. User click on settings.
2. Click on "set goal". 
3. Type in numerical value for distance, and choose "ft", "mi", or "yd" for a unit of measurement. 
Alternative flows:
1. App is closed out.
2. User goes back to main screen of app. 

Use Case: Choose Activity
Actor: User 
Description: User sets an activity they want to do in order to fulfill the alarm clock's distance requirements. 
Precondition: User is on the settings section of the app 
Post-condition: Acitvity is set 
Main flow:
1. User click on settings.
2. Click on "choose activity". 
3. Choose between walking, running, or biking. 
Alternative flows:
1. App is closed out.
2. User goes back to main screen of app.

---------------------------------------------------------------------------------------------------------------

#7 User Stories

**1.)** As a user, I want to be active so that I have a productive morning. (Priority: 3, Estimated time: ~13-16 hours)

**2.)** As a heavy sleeper, I want a loud and somewhat high-pitched alarm sound so that I wake up. (Priority: 3, Estimated time: ~13-16 hours)

**3.)** As someone who sleeps in a lot, I want to be given a task in order to shut off my alarm so that I don't laze around in bed. (Priority: 4, Estimated time: ~15-20 hours)

**4.)** As an ambitious user, I want to set higher distance goals so that I can challenge myself. (Priority 2: Estimated time: ~4-5 hours)

**5.)** As a fitness-oriented user, I want to be able to track my walking distance without having to set up an alarm. (Priority: 4, Estimated time: ~15-20 hours)

**6.)** As a user, I want to unlock new features so that I can have fun. (Priority: 4, Estimated time: ~15-20 hours)

**7.)** As a disciplined sleeper, I want my friends to wake up so that we all can do things at the same time. (Priority: 2, Estimated time: ~15-20 hours)

**8.)** As someone rarely motivated, I want to see my progress over time so that I can feel accomplished. (Priority 4: Estimated time ~15-20 hours)

**9.)** As a user, I want to save my alarm settings so that I can save time. (Priority: 2, Estimated time: ~15-20 hours)

**10.)** As a user, I want my walks to be timed so that I can aim to improve my walking speed. (Priority: 3, Estimated time: ~13-16 hours)

**11.)** As a user, I want a concise navigation bar so that I can easily learn it. (Priority: 1, Estimated time: ~4-5 hours)

**12.)** As a runner, I want the option to track my distance in miles so that I don't have to convert units of measurement. (Priority: 3, Estimated time: ~13-16 hours)
