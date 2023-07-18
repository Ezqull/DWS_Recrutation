# MOK YOK IT - Task 1

In this task my goal was to create *.csv* file from *.json* file. There were also additional requirements, as sorting and filtering the data.

## Structure of the project

The project is created with Maven, it allowed me to easily download needed dependencies the easy way.
### In main folder there are few files and directories:
* `statuses.json` - It contains list of records, which store information about client service;
* `REAME.md` - Markdown file which contains the description of the task;
* `.gitignore` - The file that allows me to push the project to the git repository without unnecessary files/directories
* `pom.xml` - Maven configuration file;
* `src` - It's the directory of the code for this task.

In the `src` directory we can find a few different classes. 
- Default **Main** class contains both **JsonReader** and **JsonReader** to run whole logic they store;
- **Status** class in *model* package, contains the model of single Json object from `statuses.json`;
- **StatusComparator** in *model/comparator* package, it's a custom Comparator I created in order to complete the task;
- **JsonReader** and **JsonReader** in *converter* package are responsible for the whole logic of the program.