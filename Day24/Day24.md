# 代码随想录算法训练营第二十四天
## [93.Problem Restore IP Address](https://leetcode.com/problems/restore-ip-addresses/description/)

A **valid IP address** consists of exactly four integers separated by single dots. Each integer is between `0` and `255` (**inclusive**) and cannot have leading zeros.

* For example, `"0.1.2.201"` and `"192.168.1.1"` are **valid** IP addresses, but `"0.011.255.245"`, `"192.168.1.312"` and `"192.168@1.1"` are **invalid** IP addresses.
  
Given a string `s` containing only digits, return all possible valid IP addresses that can be formed by inserting dots into `s`. You are not allowed to reorder or remove any digits in `s`. You may return the valid IP 
addresses in **any** order.

**Example 1:**

**Input:** s = "25525511135" <br>
**Output:** ["255.255.11.135","255.255.111.35"]

**Ideas:**
1. **Determining the Type and Parameters of the Recursive Function**:
* Define a global variable:An array result to store the collection of results
* The function type is void, as it does not return any value.
* For parameters, we need `startIndex` to avoid duplicate results. We also need `pointNum` to record the number of commas.

2. **Determine the Termination Conditions:**
* If `pointNum == 3`, that means the string has been partitioned into 4 parts.
* Besides, we have to check if the substring is valid. If they are valid, we can add them to the result.

3. **Single-Layer Search Logic:**
* In the loop `for (int i = startIndex; i < s.size(); i++)`, we define the starting position startIndex. Thus, `[startIndex, i]` represents the substring to be extracted.
* Then, we check whether this substring is a valid IP. If it is, we add it to the result, which is used to record the palindromic substrings obtained from the partition.

4. **Check if the substring is valid**
* Begin with `0` is invalid.
* Including non-positive integer is invalid.
* If the number is more than 255, then it's invalid.

```Java
public class ValidIP {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return result; // Trimming.
        backtracking(s, 0, 0);
        return result;
    }

    public void backtracking(String s, int startIndex, int pointSum) {
        if (pointSum == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointSum++;
                backtracking(s, i + 2, pointSum);
                pointSum--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            }else{
                break;
            }
        }
    }

//Check if the substring is valid.
public boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
```

## []()

























