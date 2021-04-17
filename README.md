# Directory Files Randomizer
Simple program that appends random numbers to each file in a directory.

## How does it works?
This program works by generating random numbers (with the upper bound being the number of files in the current folder)
for all files in the directory set by the user. For example, let's say a folder has a file called "file1.txt", what the
program will do, is append a random number to this file's name. Now the file's name will be, for example, "3 - file1.txt".
By appending random numbers like this, it's possible to generate a random ordering of the files in a given folder.

## Setup instructions
To get the software running you either need to run the project in IntelliJ IDEA or compile the source manually.
To compile the source, you first need to ensure that you have the JDK (Java Development Kit, complete with the JRE) installed in your machine.
Once you have the JDK and the ```JAVA_HOME``` environmental variable set, you are ready to compile the source.
  1. Open a command line interface, and navigate to the folder containing the source;
  2. Type ```javac $(find . -name '*.java')``` to compile all source files in the project;
  3. Navigate to /src/br/com/mathsemilio/directoryfilesrandomizer/ and find the ```Main.class``` file;
  4. Type ```java Main``` to run the program.
  
## License
```
   Copyright 2021 Matt Menezes

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```