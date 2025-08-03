https://www.selenium.dev/
https://www.youtube.com/@softwaretestingmentor

# 📘 Selenium Xpath Guide

This document is a quick reference and learning guide for using **Xpath** in **Selenium WebDriver**. It covers different selector types, functions, axes, and examples to help locate elements efficiently.

---

## 📌 1. Order of Xpath Selectors (Recommended Priority)

```text
1. id
2. name
3. linkText
4. partialLinkText
5. className
6. tagName
7. cssSelector
8. xpath
```

---

## 🔤 2. Basic Xpath Format

```xpath
//tagname[@attribute='value']
```

**Example:**

```xpath
//input[@id='search-box']
```

---

## 🧭 3. Types of Xpath

### ✅ Absolute Xpath

* Uses a **single forward slash ( / )**
* Starts from the root (html) element

```xpath
/html/body/div[1]/input
```

### ✅ Relative Xpath

* Uses **double forward slash ( // )**
* Starts from anywhere in the document

```xpath
//input[@name='username']
```

---

## 🧩 4. Xpath Functions

### 🔹 `starts-with()`

```xpath
//input[starts-with(@name,'user')]
```

**Example:**

Finds inputs with names like `user123`, `userName`, etc.

### 🔹 `contains()`

```xpath
//button[contains(@class,'submit')]
```

**Example:**

Selects buttons whose class includes `submit`.

### 🔹 `text()`

```xpath
//h2[text()='Welcome back!']
```

**Example:**

Finds an `<h2>` element with the exact text "Welcome back!".

---

## ⚖️ 5. Using AND & OR in Xpath

### 🔹 OR Operator

```xpath
//input[@id='email' or @name='email']
```

**Example:** Matches if `id=email` **OR** `name=email`.

### 🔹 AND Operator

```xpath
//input[@type='text' and @name='username']
```

**Example:** Matches if **both** attributes exist.

---

## 🧱 6. Xpath Axes Methods

Axes let you navigate the DOM relative to a known element.

### 🔹 `parent::`

Selects the parent of a node.

```xpath
//span[@id='child-element']//parent::div
```

**Example:** Gets the `<div>` that contains a `<span>` with `id='child-element'`.

---

### 🔹 `child::`

Selects all children of the current node.

```xpath
//div[@class='form-group']//child::input
```

**Example:** Gets `<input>` elements inside a `<div>` with class `form-group`.

---

### 🔹 `self::`

Selects the current node itself.

```xpath
//button[@type='submit']//self::button
```

**Example:** Refers directly to the same `<button>` element.

---

## ✅ 7. Full Selenium Example (Java)

```java
WebDriver driver = new ChromeDriver();
driver.get("https://example.com");

// Basic Xpath
WebElement input = driver.findElement(By.xpath("//input[@id='search']"));

// Using contains()
WebElement button = driver.findElement(By.xpath("//button[contains(@class,'submit')]"));

// Using text()
WebElement heading = driver.findElement(By.xpath("//h1[text()='Welcome']"));

// Using AND
WebElement userInput = driver.findElement(By.xpath("//input[@type='text' and @name='username']"));

// Using parent axis
WebElement parentDiv = driver.findElement(By.xpath("//label[@for='email']//parent::div"));
```

---

## 💡 Best Practices

* Prefer **relative Xpath** over absolute.
* Avoid long, brittle Xpath chains like `/html/body/div[3]/div[2]/...`.
* Use functions (`contains`, `starts-with`) when IDs or classes are dynamic.
* Combine attributes with `and`/`or` for precise targeting.
* Use developer tools (F12) to test and verify Xpaths in the browser.
----------------------------------------------------------------------------------------------------
Xpath Axes Methods


Descendant and Descendant-or-Self
Descendant: Selecciona todos los descendientes (hijos, nietos, etc.) del nodo actual.

Ejemplo: //tagname[@attribute='value']//descendant::tagname

Descendant-or-Self: Selecciona el nodo actual y todos sus descendientes.

Ejemplo: //tagname[@attribute='value']//descendant-or-self::tagname

Ancestor and Ancestor-or-Self
Ancestor: Selecciona todos los ancestros (padres, abuelos, etc.) del nodo actual.

Ejemplo: //tagname[@attribute='value']//ancestor::tagname

Ancestor-or-Self: Selecciona el nodo actual y todos sus ancestros.

Ejemplo: //tagname[@attribute='value']//ancestor-or-self::tagname

Following and Following-Sibling
Following: Selecciona todos los nodos que aparecen después del nodo actual.

Ejemplo: //tagname[@attribute='value']//following::tagname

Following-Sibling: Selecciona todos los nodos que tienen el mismo padre que el nodo actual y aparecen después de él.

Ejemplo: //tagname[@attribute='value']//following-sibling::tagname

Preceding and Preceding-Sibling
Preceding: Selecciona todos los nodos que aparecen antes del nodo actual.

Ejemplo: //tagname[@attribute='value']//preceding::tagname

Preceding-Sibling: Selecciona todos los nodos que tienen el mismo padre que el nodo actual y aparecen antes de él.

Ejemplo: //tagname[@attribute='value']//preceding-sibling::tagname

CSS Selector Basics
Syntax and Examples
Tagname and Attribute Selector:

Sintaxis: tagname[attributeName='attributeValue']

Ejemplo: input[id='first_name']

ID Selector
Sintaxis: tagname#elementID

Ejemplo: input#first_name

Class Selector
Sintaxis: tagname.className

Ejemplo: input.signUp

Attribute Selector
Sintaxis: tagname[attributeName='attributeValue']

Ejemplo: input[value='sign me up']

Advanced CSS Selectors
Uso avanzado combinando etiquetas, IDs y clases.

Ejemplo: input.signup[type='submit'][value='sign me up']

Sub-string Selector
Coincidencias de sub-cadenas para identificar elementos dinámicos.

Caracteres especiales: ^, $, *.

Ejemplos:

input[name^='country_c'] (prefijo)

input[name$='y_client'] (sufijo)

input[name*='try_cl'] (sub-cadena)




----------------------------------------------------------------------------------------------------

FINDING CHILD OR SUBCHILD ELEMENTS

- direct child
  - child combinator (>) is used to select direct child
  - syntax: tagname[attributeName='attributeValue'] > tagname[attributeName='attributeValue']
  - example: select#country > option[value='AU']

- child or subchild
  - descendant combinator () is used to select child or subchild
  - syntax: tagname[attributeName='attributeValue'] tagname[attributeName='attributeValue']
  - example: form#deorg_for div





CSS SELECTOR - NEXT SIBLING

- sibling elements are located using the (+) operator
- adjacent sibling combinator (+) separates two CSS selectors and matches the second web elemnet only if
it inmediadiately follows the first webelement, and both are the child of same parent webelement.


- format:
    tagNmae[attributeName='attributeValue']+tagname[attributeName='attributeValue']




CSS SELETOR PSEUDO-CLASSES (FIRST-CHILD, LAST-CHILD, NTH-CHILD, NTH-LAST-CHILD)

- A CSS pseudo-class is a keyword added to a selector that specifies a special state of the selected webelement

- first-child: returns first element from the group of sibling elements
  - select#job_role>:first-child
  
- last-child: returns last element from the group fo sibling elements
  - select#job_role>:last-child

- nth-child(): returns elements based on their position in a group of siblings
  - select#job_role>:nth-child(4)
  
- nth-las-child(): returns elements based on their position among a group of siblings, counting from the end.
  - select#job_role>:nth-last-child(2)







CSS SELECTOR PSEUDO-CLASSES CONT. (first-of-type, last-of-type, nth-of-type())

- first-of-type: returns the first element of its type among a group of sibling elements
  - form#deorg_form>input:first-of-type
- last-of-type: returns the last element of its type among a group of sibling elements
  - form#deorg_form>input:last-of-type
- nth-of-type: matches elements of a given type, based on their position among a group of siblings.
  - form#deorg_form>input:nth-of-type







----------------------------------------------------------------------------------------------------------------


BASIC METHODS IN WEBDRIVER INTERFACE

- get()
- manage()  - gets the options interface
- getcurrentURL() - get a string representing the current URL that the browser is lookign at
- getTitle()
- getPageSource() - get the source of the last loaded page
- navigate() - an abstraction allowing the driver to access the browser's history and to navigate to a given URL
- quit() - closing every associated window
- close() - close the current window.