# Lecture Attendance System Test Automation

This project enables automatic login to the university's remote education system, followed by joining the class and turning off the camera and microphone during class hours, and automatically leaving the class after 1 hour. Jenkins is used to automatically run the tests at the scheduled days and times.
<p align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/Konya_Teknik_%C3%9Cniversitesi_logo.svg/1024px-Konya_Teknik_%C3%9Cniversitesi_logo.svg.png" alt="Project Logo" width="300" />
</p>
Requirements

The project requires the following programs:

    Java JDK
    Maven
    Jenkins
    Selenium WebDriver

Installation

    Install Java JDK on your computer.
    Install Maven on your computer.
    Install Jenkins on your computer.
    Include Selenium WebDriver in your project.

Usage

    Go to the directory where the project is located.
    Run the project using the mvn test command.

Jenkins Integration

We set up Jenkins integration in the form of a pipeline because:

    We have multiple courses under the same project, each with different schedules on different days.
    To run the tests for different courses at different times under the same project, we use pipelines.

Here are the steps for Jenkins integration:

    Log in to the Jenkins dashboard and click on "New Item."
    In the new item page, enter "MyJavaPipeline" in the "item name" field, select "Pipeline," and click "OK."
    Find the "Pipeline" section on the opened page and set the "Definition" to "Pipeline script."
    Paste the following script into the "Script" section:

groovy

    pipeline {
        agent any
        triggers {
            cron('00 17 * * 3') // cron expression "00 17 * * 3" means at minute 00, hour 17:00, every day of the month, and every Wednesday (day of       the week).
        }
        stages {
            stage('Checkout') {
                steps {
                    git branch: 'main', url: 'https://github.com/onlyfatih/DersTakipSistemiTestOtomasyonu.git'
                }
            }
            stage('Build and Test') {
                steps {
                    sh 'mvn clean test -Dtest=AlgoritmaAnaliziLoginTests'
                }
            }
        }
    }
    
    pipeline {
        agent any
        triggers {
            cron('00 15 * * 4') // cron expression "00 15 * * 4" means at minute 00, hour 15:00, every day of the month, and every Thursday (day of     the week).
        }
        stages {
            stage('Checkout') {
                steps {
                    git branch: 'main', url: 'https://github.com/onlyfatih/DersTakipSistemiTestOtomasyonu.git'
                }
            }
            stage('Build and Test') {
                steps {
                    sh 'mvn clean test -Dtest=ParalelProgramlamaLoginTests'
                }
            }
        }
    }

1- Click the "Save" button to save the project.
2- Click on the "MyJavaPipeline" project in the Jenkins dashboard to go to the project page.
3- Click the "Build Now" button to run the project.
4- To ensure that your tests have run successfully, you can check the "Console Output" section on the project page.

Contribution

To contribute to this project, please send a pull request.
License

This project is licensed under the MIT License. For detailed information, please refer to the LICENSE file.
