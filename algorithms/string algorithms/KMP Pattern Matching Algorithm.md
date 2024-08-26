# KMP Algorithm
KMP algorithm stands for Knuth-Morris-Pratt algorithm. It is a string searching algorithm meaning we can find if a substring (pattern) is present or not in the given string.
KMP is a smart optimization of Naive Pattern Matching algorithm. So before diving into KMP algorithm let's revisit how does a naive approach work?

## Problem Statement
Two strings are given. One is  a pattern and another is a string in which we need to look for if the pattern exists or not.
Size of pattern = m
Size of string = n

### Naive Approach Algorithm's pseudocode:
This method uses O(1) space complexity, but in terms of space complexity O((n-m)*m) in worst case.

```
1. n = string A's size and m = pattern P's size
2. if (n < m)  return false // pattern not found
3. for i = 0 -> n - m:
    a. if A[i] == P[0]:
    b. for loop j == i + 1 to m:
        i. if A[j] != P[j-i]: break;
        ii. if i == m - 1: return true. // We have reached to final element in the pattern, and it also matched so success
4. return false
```

**As mentioned above the time complexity for this approach is O(n*m). Is there a way we can improve our logic to save some time?**
Yes

**How?**
To save time, KMP comes in the picture as it can solve this problem by doing the same thing in O(n+m) time complexity only. You can see that's a very big improvements in terms of time.
But to save time, we need to sacrifice the space complexity. Remember saving time means compromising space.

**Process:**

1. Using needle, calculate Longest Prefix Suffix (LPS) array. It represents the longest prefix of a substring that is also a suffix of substring.
2. Iterate over the haystack's characters one by one.
3. If the characters are same then increment the pointers of both strings.
4. If the characters are not same, that means use the LPS array, get the next element of needle to compare with needle' character.
5. If the needle exists return the index of starting in the haystack
6. Else return -1

## Calculate LPS (Longest Prefix Suffic) Array

```java
int[] getLPS(String needle) {
    int[] lps = new int[needle.length()];
    int length = 0; // Length of previously matched prefix as suffix
    int i = 1; // First element will be always zero of the LPS as the whole string cannot be considered as prefix or suffix of the string. So first element will be zero.
    while (i < lps.length) {
        if (needle.charAt(i) == needle.charAt(length)) {
            lps[i] = length + 1;
            length++;
            i++;
        } else {
            if (length == 0) {
                lps[i] == 0;
                i++;
            } else {
                length = needle[length - 1];
            }
        }
    }
}
```

## KMP String Matching in Java using above function:

```java
int indexOfSubstring(String haystack, String needle) {
    int[] lps = getLPS(needle);
    int i = 0, j = 0; // Pointers for both strings.
    while (i < haystack.length()) {
        if (haystack.charAt(i) == needle.charAt(j)) {
            i++;
            j++;
        } else {
            if (j == 0) i++;
            else j = lps[j - 1];
        }
        if (j == needle.length()) return (i - j); // found the complete match of needle in the haystack.
    }
}
```

> **_LeetCode:_**\
> 28: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/