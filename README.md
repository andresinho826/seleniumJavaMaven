
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
