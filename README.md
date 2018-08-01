### Summary
1. In IDEA open project `cucumber_project` from "Desktop/cucumber_project"
2. Pull the latest changes:
   ![Alt text](img/git_pull.png?raw=true "git pull via IDEA")
3. In IDEA check in project structure, that:
   * Project settings:
   ![Alt text](img/project_settings.png?raw=true "Project Settings")
   * Modules settings:
   ![Alt text](img/module_settings.png?raw=true "Module Settings")
4. Create a branch:
   ![Alt text](img/git_new_branch_1.png?raw=true "git new branch 1 via IDEA")
   ![Alt text](img/git_new_branch_2.png?raw=true "git new branch 2 via IDEA")
   ![Alt text](img/git_new_branch_3.png?raw=true "git new branch 3 via IDEA")
5. After making changes do:
   ![Alt text](img/git_add.png?raw=true "git add via IDEA")
   ![Alt text](img/git_commit_1.png?raw=true "git commit 1 via IDEA")
   ![Alt text](img/git_commit_2.png?raw=true "git commit 2 via IDEA")
   ![Alt text](img/git_commit_3.png?raw=true "git commit 3 via IDEA")
   ![Alt text](img/git_push_1.png?raw=true "git push 1 via IDEA")
   ![Alt text](img/git_push_2.png?raw=true "git push 2 via IDEA")
   
   sNote: replace <name_surname> with your name and surnameit 

### Task
Create a new Feature file (e.g. in the folder "features" click "New" -> "File" -> "Task.feature"), and inside write a few scenarios for the page https://kristinek.github.io/test-sample/tasks/task4 
1) enter some values into the field, press "Send", check that correct data appears
2) enter some values into the field (do not fill the "name" field), press "Send", press "Yes", check that the correct message appears - "Thank you for your feedback!"
3) enter some values into the field (fill the "name" field), press "Send", press "Yes", check that the correct message appears - "Thank you, " + name_you_entered + ", for your feedback!"
4) enter some values into the field, press "Send", press "No", check that the values which where filled previously are still filled

### Feedback
