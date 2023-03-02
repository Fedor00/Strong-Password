# Strong-Password

A password is considered strong if below conditions are all met:
  1. It has at least 6 characters and at most 20 characters.
  2. It must contain at least one lowercase letter, at least one uppercase letter, and at least one
    digit.
  3. It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..."
    is strong, assuming other conditions are met).
Write an algorithm that takes a string s as input, and return the MINIMUM change required to
make s a strong password. If s is already strong, return 0.
Insertion, deletion or replace of any one character are all considered as one change.

If the length of the input string is less than 6, the number of repeating characters is taken into account only if the minimum number of required changes is 0. 
In this case, we calculate the gap between the length of the string and 6 (6 - length), and add this value to the minimum number of required changes. 
If the sum of the length and the minimum number of required changes is greater than 6, we add the difference between the sum and 6 to the minimum number of required 
changes. For example, if the input string is "/////", the minimum number of required changes is 3 (due to the missing characters), and the length is 5. 
The gap between the length and 6 is 1, so we add 1 to the minimum number of required changes. The sum of the length and the minimum number of required changes is 8, 
which is greater than 6, so we add the difference between 8 and 6 (2) to the minimum number of required changes. 
Therefore, the final minimum number of required changes is 3.

If the length of the input string is greater than or equal to 6, we check if the number of repeating characters is greater than the minimum number of required changes.
If it is, we add the difference between the number of repeating characters and the minimum number of required changes to the minimum number of required changes. 
This is because one missing character (an uppercase letter, a lowercase letter, or a digit) is equivalent to one repeating character.
For example, if the input string is "aaa.;'iiikkk", the number of repeating characters is 3, and the minimum number of required changes is 2 
(due to the missing uppercase letter and digit). Therefore, we need to make a total of 3 changes, which can be achieved by replacing the first "a" with "A", replacing 
the last "k" with "1", and swapping the positions of the "i" and "k" characters. Therefore, the final string is "aaA.;'ii1kki".

If the length of the input string is greater than 20, we delete all characters beyond the 20th character. This is to ensure that the output string does not exceed 
the maximum allowed length.
