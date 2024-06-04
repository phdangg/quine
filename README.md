# Quine Class Documentation
## Overview
The Quine class is designed to introspectively analyze and print the structure of a Java class, including its fields, constructors, and methods along with their argument types and names. This utility is useful for understanding the internal workings of a class, making it easier for developers to document and debug their code.
## Features
- **Field Extraction**: Retrieves and formats all declared fields of a class.
- **Constructor Extraction**: Retrieves and formats all public constructors of a class, including parameter types and names.
- **Method Extraction**: Retrieves and formats all public methods of a class, including parameter types and names.
- **Source Code Generation**: Generates a source-like representation of the class.
## Usage
### Getting Started
To use the Quine class, simply call the static sourceCode method with the class you want to analyze as its parameter.
```java
public class Example {
    private int number;
    private String text;

    public Example(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static void main(String[] args) {
        System.out.println(Quine.sourceCode(Example.class));
    }
}
```
Running the main method will print the structure of the Example class.
### Output
The output will be a string representation of the Example class structure:
```
public class Example {
	private int number
	private String text
	public Example(int arg0,String arg1)
	public void setNumber(int arg0)
	public static void main(String[] arg0)
	public int getNumber()
	public String getText()
	public void setText(String arg0)
	public boolean Object arg0.equals(Object arg0)
	public String Object.toString()
	public native int Object.hashCode()
	public final native Class Object.getClass()
	public final native void Object.notify()
	public final native void Object.notifyAll()
	public final void Object.wait(long arg0) throws InterruptedException
	public final void Object.wait(long arg0,int arg1) throws InterruptedException
	public final void Object.wait() throws InterruptedException
}
```
## Methods

### `getDefault`
- **Purpose**: Strips package names from class and type names for readability.
- **Signature**:
  ```java
  private static String getDefault(String s, Class<?> cl)
  private static String getDefault(String s)
### `getDeclaredFields`
- **Purpose**: Retrieves and formats all declared fields of a class.
- **Signature**:
  ```java
  public static String getDeclaredFields(Class<?> cl)
### `constructorWithArgName`
- **Purpose**: Adds argument names to constructor parameter types for readability 
- **Signature**:
  ```java
  private static String constructorWithArgName(String c, String parameters)
### `getConstructor`
- **Purpose**: Retrieves and formats all constructors of a class. 
- **Signature**:
  ```java
  public static String getConstructor(Class<?> cl)
### `getMethods`
- **Purpose**: Retrieves and formats all methods of a class. 
- **Signature**:
  ```java
  public static String getMethods(Class<?> cl)
### `sourceCode`
- **Purpose**: Generates a source-like representation of the class structure. 
- **Signature**:
  ```java
  public static String sourceCode(Class<?> cl)
### `toString`
- **Purpose**: Overrides the toString method to return the structure of the Quine class itself. 
- **Signature**:
  ```java
  @Override
  public String toString()
