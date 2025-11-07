🧪 Selenium Automation Project (JUnit + Java - IntelliJ)
This repository contains automation scripts using Selenium WebDriver, JUnit, and Java, developed with IntelliJ IDEA.

📌 Project Tasks
✅ Task 1: Automate Digital Unite Web Form
🔗 URL: Digital Unite Webform

Steps:
Fill all fields (Full Name, Email, Age Range, etc.)
Upload a file under 2MB (e.g. sample_upload.txt)
Click Submit
Assert: Thank you for your submission!
video Presentation
https://drive.google.com/file/d/1r4klfrhlhraT-biNWkjOJtDoawXkdEzS/view?usp=sharing

Reports
digital

✅ Task 2: Automate Guest Registration Form
🔗 URL: WP Everest Guest Registration Form

Steps:
Fill in:
Firstname, Lastname, Email
Gender, DOB, Nationality, Phone
Country: Bangladesh
Agree to Terms & Conditions
Submit the form
Assert successful registration
video Presentation
https://drive.google.com/file/d/109Nz1ZzIjWvY8vDWkZBb-xn9QNYfZh_b/view?usp=drive_link

Report
demo

✅ Task 3: Scrape DSE Table Data
🔗 URL: DSE Latest Share Price

Steps:
Extract all table data
Print to console
Save output to share_prices.txt file
video Presentation
https://drive.google.com/file/d/1bIdIKT5GgAA7RQVHBhm3CIe8_X24AwE_/view?usp=drive_link

Report
stock

🧰 Technologies Used
Java
Selenium WebDriver
JUnit 5
IntelliJ IDEA
ChromeDriver
Gradle (recommended)
🗂 Project Structure (IntelliJ)
└── src/

└── test/

└── java/

├── Task1_DigitalUniteFormTest.java

├── Task2_WPEverestFormTest.java

└── Task3_DSEWebScraperTest.java

▶️ How to Run in IntelliJ
1. Import Project
Open IntelliJ IDEA
Choose: File → Open → Select Project Folder
2. Set Up ChromeDriver
Download chromedriver from https://chromedriver.chromium.org/downloads
Place it in your system path or project root
Set path if needed:
System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
