# 代码随想录算法训练营第九天
## [151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/description/)

Given an input string `s`, reverse the order of the **words**.

A **word** is defined as a sequence of non-space characters. The **words** in `s` will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

**Note** that `s` may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

**Example1**

**Input:** s = "  hello world  "<br>
**Output:** "world hello"<br>
**Explanation:** Your reversed string should not contain leading or trailing spaces.

**Ideas:**<br>
* Remove extra spaces in the string `s`.
* Reverse the whole string `s`.
* Reverse each word in the string.

```Java
