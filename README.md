### HOW TO RUN THE PROJECT:
1. This project is built as a maven project with dependencies from various libraries. 

 a). Right click on project name > Configure > Convert to Maven Project.

 b). Keep all default options and click finish.

 c). Copy/paste the pom.xml file I provided.

2. After setting up this project as a maven project, please copy over all of our files including all source .java files and the HRDataset_v13.csv file. Note that HRDataset_v13.csv should be directly under your project name folder, not inside the src folder.


3. After all the files are set up, you can run the whole project from the ProjectRunner.java file.


4. After clicking "Run", you should see the outputs in the output window and all the graphs should be produced in different internet browser tabs. 



### PROJECT OVERVIEW:
This is a Java data science project with a human resource dataset found on Kaggle. The dataset can be found here: https://www.kaggle.com/rhuebner/human-resources-data-set.

This project contains 4 classes:

- The Data class imports the raw dataset and contains different methods for cleaning, wrangling and exploring the data.

- The Graphs class does all the data visualizations. I plotted pie charts, histograms and box plots in this class.

- The PredictPayRate class uses linear regression to predict employees' pay rates.  

- Lastly, the ProjectRunner class runs the whole project.

 Both the Graphs class and the PredictPayRate class use the data frame from the Data class.
 
 Furthermore, I have done JUnit testing for both the Data class and the PredictPayRate class. 
 

### APPENDIX:

##### The data
----------------------------------------------------
     0  |           Employee_Name  |       STRING  |
     1  |                   EmpID  |      INTEGER  |
     2  |               MarriedID  |      INTEGER  |
     3  |                GenderID  |      INTEGER  |
     4  |                     Sex  |       STRING  |
     5  |             EmpStatusID  |      INTEGER  |
     6  |                  DeptID  |      INTEGER  |
     7  |              Department  |       STRING  |
     8  |              PositionID  |      INTEGER  |
     9  |                Position  |       STRING  |
    10  |                   State  |       STRING  |
    11  |             CitizenDesc  |       STRING  |
    12  |          HispanicLatino  |       STRING  |
    13  |                RaceDesc  |       STRING  |
    14  |  FromDiversityJobFairID  |      INTEGER  |
    15  |             PerfScoreID  |      INTEGER  |
    16  |        PerformanceScore  |       STRING  |
    17  |         EmpSatisfaction  |      INTEGER  |
    18  |                 PayRate  |       DOUBLE  |

