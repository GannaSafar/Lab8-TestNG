# Lab 8 TestNG Hands-On Project

This project contains ready-to-run solutions for:
- Hands-On 1: Test lifecycle ordering
- Hands-On 2: Cross-browser + DataProvider login
- Hands-On 3: Groups + reporting setup
- Hands-On 4: GitHub Actions CI pipeline

## Run order
1. Exercise 1: right-click `Exercise1_TestLifecycle` and run.
2. Exercise 3: right-click `src/test/resources/testng-groups.xml` and run.
3. Exercise 2: right-click `src/test/resources/testng-cross-browser.xml` and run.
4. Exercise 4: push the project to GitHub and let `.github/workflows/testng-ci.yml` run.

## Notes
- Use JDK 17.
- Load Maven changes after opening the project.
- Chrome and Firefox should be installed for Exercise 2.
- WebDriverManager is included, so you do not need to install drivers manually.
