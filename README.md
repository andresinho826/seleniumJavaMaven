SELENIUM XPATH

----------------------------- ORDER TO XPATH
1.id
2.name
3.linktext
4.partial linktext
5.class name
6.tag name
7. css selector
8. xpath





----------------------------- basic format of Xpath

//tagname[@attribute='value']




----------------------------- type of Xpath

1. absolute Xpath

we use only single forward slash (/)

2. relative xpath

it begins with the double forward slash (//)



----------------------------- Xpath funtion - "star-with"

format:
//tagname[starts-with(@attribute,'value')]


-----------------------------Xpath funtion - "contains"

//tagname[contains(@attribute,'value')]


----------------------------- Xpath funtion - "text()" method

//tagname[text()='actualText']


----------------------------- how to use AND & OR in selenium xpath

- very helpful if you want to use more than two attributes to find element on webpage

- //tagname[@attribute='value' or @attribute='value']
- //tagname[@attribute='value' and @attribute='value']



------------------------- Xpath axes methods (parent, child, self)

- it represents a relationship to the context node
- it is used in locating nodes relative to that node in the tree

- Parent: selects the parent of the context ( current) node
    - //tagname[@attribute='value']//parent::tagname


- child: selects all children of the current node
    - //tagname[@attribute='value']//child::tagname


- self: selects the current node
  - //tagname[@attribute='value']//self::tagname