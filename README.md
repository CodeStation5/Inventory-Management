<strong>** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS
Welcome to Java Frameworks! This is an opportunity for students to implement user interfaces and learn to leverage existing frameworks, assets, and content for object-oriented programming.
FOR SPECIFIC TASK INSTRUCTIONS AND REQUIREMENTS FOR THIS ASSESSMENT, PLEASE REFER TO THE COURSE PAGE.
## Description of Application
For this project, you will use the Integrated Development Environment (IDE) link in the web links section of this assessment to install the IDE, IntelliJ IDEA (Ultimate Edition). All relevant links are on the course page. Please refer to the course of study for specific links. You will sign up for a free student license using your WGU.edu email address. Please see the “IntelliJ Ultimate Edition Instructions” attachment for instructions on how do this. Next you will download the “Inventory Management Application Template Code” provided in the web links section and open it in IntelliJ IDEA (Ultimate Edition). You will upload this project to a private external GitLab repository and backup regularly. As a part of this, you have been provided with a base code (starting point). 

## Description of Changes
Refer to GitLab commit history for full changes

### <strong>Section C<strong>

>MainScreen.html
>* Line 14 > Changed title of page
>* Line 19 > Added company name to shop heading
>* Line 20 > Added link to AboutUs.html
>* Line 83-84 > Added Buy Now button 
>* Line 39-40, 49-50 > Added min/max options

### <strong>Section D<strong>
>AboutPageController:
>* Line 1-35 > Added @GetMapping for about, contact, resources html pages

>about.html:
>* Line 121 > Filled in page with company info with no styling.
>* Line 16-19 > Updated about us page with more info
>* Line 27-39 > Added footer with contact info

>contact.html:
>* Line 1-42 > Filled with contact info and used flex box

>resources.html:
>* Line 1-51 > Filled with contact info and used flex box

>mainscreen.html:
>* Line 18-28 > Added flex header with title and page buttons

### <strong>Section E<strong>
>BootStrapData.Java:
>* Line 76-112 > Added code for 5 parts and their set functions
>* Line 114-119 > Added code to save parts
>* Line 122-138 > Added code to create 5 products and save them
>* Line 121-123, 141-144 > Added else to both parts and products
>* Line 124-129 > added inhousepart use
>* Line 86, 94, 102, 110, 118> Corrected product names

### <strong>Section F<strong>
>ItemPurchaseController.Java:
>* Line 1-35 > Created base item sold/unsold controller to return buy view
>* Line 12 > Added @controller mvc

>ItemNotSold.html
>* Line 1-11 > Created html to return an item that's out of stock

>ItemSold.html
>* Line 1-11 > Created html to return an item that's been sold

### <strong>Section G<strong>
>OutSourcedPartForm.html
>* Line 27-31 > Added error for low/high inventory + user text input

>InHousePartForm.html
>* Line 27-31 > Added error for low/high inventory + user text input

### <strong>Section H<strong>

>AddInhousePartController.Java
>* Line 44-45 > Added ElseIf to validate inventory within Min/Max range

>AddInhousePartController.Java
 >* Line 44-47 > Added ElseIf to validate inventory within Min/Max range
 >* Line 29 > Added @ItemListCheck validator

>AddOutsourcedPartController.Java
>* Line 44-47 > Added ElseIf to validate inventory within Min/Max range
>* Line 28 > Added @ItemListCheck validator
>* Line 47-48 > Corrected return statement
 
>Part.Java
>* Line 33-34 > Added @Max error message for max inventory reached
>* Line 44-51 > Added Part constructor to take in min/max values
>* Line 106-117 > Added get/set for min/max inventory
>* Line 19 > Added @ItemListCheck validator

>Product.Java
>* Line 19 > Added @ValidPartsForProduct validator

>ItemListCheck.Java
>* Line 1-21 > Added validation to make sure inventory between min/max values
>* Line 10 > Made correction to @Constraint class call

>ItemListValidator.Java
>* Line 1-44 > Added validation to make sure part inventory between min/max values

>InhousePart.Java
>* Line 14 > Added @ItemListCheck validator

>OutsourcedPart.Java
>* Line 14 > Added @ItemListCheck validator

>ValidPartsForProduct
>* Line 1-24 > Item below minimum inventory validator

>ValidPartsProductValidator
>* Line 1-46 > Validator for ValidPartsForProduct


### <strong>Section I<strong>
PartTest.Java
>* Line 159-174 > Added 2 tests, validating min/max inventory within range



## SUPPORT
If you need additional support, please navigate to the course page and reach out to your course instructor.
## FUTURE USE
Take this opportunity to create or add to a simple resume portfolio to highlight and showcase your work for future use in career search, experience, and education!
