# Election-Poll
General Workings <br />
This android application allows users to take a poll on who they would like to vote for in the Galway election in 2016. There is an option to view the stat page or take the poll. If the user opts to take the poll, they are firstly asked if they are planning to vote and if they are eligible to vote. If they answer no to these questions, they are brought to a screen that informs them that the app would like to collect information on those who are eligible to vote and are planning on voting. If the users select yes, they are brought to a list of candidates and are asked who they are voting for. Once they’ve selected their preferred candidate, they are brought to two separate pages of questions in the form of radio buttons and spinners. Once the user hits submit, the information they have just entered is sent to the database. They are thanked for filling out the questionnaire and are brought back to the main menu.

Database <br />
In search stats the user can choose to search by location, gender and age of all those polled.
When they perform a search they are brought back all polling information of those matching the criteria they searched for. There are if statements and corresponding methods to handle all options the user can click, this has resulted in excess amount of code. I’m aware that there must be an easier way to handle all these options, and not create a method for each one,  and I hope to improve in handling these in the next project.

Stats <br />
For stats the user has 3 options:
Search stats: this allows the user to view all polling information searching by gender age and locality.
View all polling Info: shows all the information from all those who have been polled.
Check count: shows the number of votes each candidate has along with their overall percentage of the votes. Similar to my statcalculations, I have a method to do this for each candidate and would have preferred to use one method that could be used for all candidates.

Design <br />
I chose a ballot box icon for the app.
Greenbutton and PinkButton are two xml files that hold the code for creating rounded corners on the various buttons used in the app. I found the code for this on stackoverflow as referenced below, and altered it to suit my preferences. 
I changed the primary colour, and primary dark colour to a dark navy, in order to change colour of the app bar and above it to match the colour scheme I have chosen.
For the list of candidates I used a custom ListView with images. I found some instructions and code from learn2crack that helped me with this.
