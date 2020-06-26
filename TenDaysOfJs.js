'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}

function main() {
    // greeting(parameterVariable);
    // performOperation()
    // arithmeticOperators()
    // console.log(factorial(6));
    // vowelsAndConsonants("asdakfmeocemowimc");
    // regexVar();
    // isPositive(3);
    // inheritance();
    // letAndConstant();
    // getGrade();
    // getLetter();
    // Rectangle();
    // getCount();
    // getDayName();
    // regexVar2();
    // getMaxLessThanK();
    // sides();
    // modifyArray();
    // regexVar3()
}

function regexVar3() {
    /*
     * Declare a RegExp object variable named 're'
     * It must match ALL occurrences of numbers in a string.
     */
    const re = new RegExp('\\d+', 'g');
    
    /*
     * Do not remove the return statement
     */
    return re;
}

function modifyArray(nums) {
    return nums.map(n => n = (n % 2 == 0) ? n * 2 : n * 3);
}

function sides(literals, ...expressions) {
    // ES6 allows destructuring of arrays into multiple variables
    const [a, p] = expressions;
    // Perform this operation only once and assign to variable
    const root = Math.sqrt((p * p) - (16 * a))
    const s1 = (p + root) / 4;
    const s2 = (p - root) / 4;
    // s2 will always be smaller because of the (-/+) above
    return ([s2, s1]);
}

class Polygon{
    constructor(sides){        
        this.sides = sides
    }
    perimeter() {
        return this.sides.reduce(function add(a,b){return a+b;})
    } 
}

function getMaxLessThanK(n, k) {
    let max_anb = 0;
    for (let b = n; b > 0; b--) {
        for (let a = b - 1; a > 0; a--) {
            if ((a & b) < k && (a & b) > max_anb){
                max_anb = (a & b);
            }
        }
    }
    return max_anb;
}

function regexVar2() {
    /*
     * Declare a RegExp object variable named 're'
     * It must match a string that starts with 'Mr.', 'Mrs.', 'Ms.', 'Dr.', or 'Er.', 
     * followed by one or more letters.
     */
    const re = /^[mrsde.]+[a-z]+$/i;
    
    /*
     * Do not remove the return statement
     */
    return re;
}

function getDayName(dateString) {
    const date = new Date(dateString);
    const options = {
      weekday: 'long'
    };
    return new Intl.DateTimeFormat('en-Us', options).format(date);
}

function getCount(objects) {
    return objects.filter(function(o){return o.x == o.y}).length
}

function Rectangle(a, b) {
    this.length = a;
    this.width = b;
    this.area = a * b;
    this.perimeter = 2 * (a + b);
}

function getSecondLargest(nums) {
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] > first) {
            second = first;
            first = nums[i]
        }
        if (nums[i] > second && nums[i] < first) {
            second = nums[i];
        }
    }
    return second;
}

function getLetter(s) {
    let letter;
    // Write your code here
    switch (true) {
        case 'aeiou'.includes(s[0]):
            letter = 'A';
            break;
        case 'bcdfg'.includes(s[0]):
            letter = 'B';
            break;
        case 'hjklm'.includes(s[0]):
            letter = 'C';
            break;
        case 'npqrstvwxyz'.includes(s[0]):
            letter = 'D';
            break;
    }
    return letter;
}

function getGrade(score) {
    return 'FEDCBA'[parseInt((score > 0 ? score - 1 : 0) / 5)];
}

function letAndConstant() {
    let r = readLine();
    const PI = Math.PI;

    // Print the area of the circle:
    console.log(PI * r * r);
    // Print the perimeter of the circle:
    console.log(PI * 2 * r);

    try {    
        // Attempt to redefine the value of constant variable PI
        PI = 0;
        // Attempt to print the value of PI
        console.log(PI);
    } catch(error) {
        console.error("You correctly declared 'PI' as a constant.");
    }
}

function inheritance() {
    if (JSON.stringify(Object.getOwnPropertyNames(Square.prototype)) === JSON.stringify([ 'constructor' ])) {
        const rec = new Rectangle(3, 4);
        const sqr = new Square(3);   
        console.log(rec.area());
        console.log(sqr.area());
    } else {
        console.log(-1);
        console.log(-1);
    }
}

Rectangle.prototype.area = function() {
    return(this.w * this.h);
};

class Square extends Rectangle {
    constructor(s) {
        super(s);
        this.h = s;
        this.w = s;
    }
};

class Rectangle {
    constructor(w, h) {
        this.w = w;
        this.h = h;
    }
}

function isPositive(a) {
    if (a > 0) {
        return 'YES';
    } else {
        throw (a === 0 ? new Error('Zero Error') : new Error('Negative Error'));
    }
}

function reverseString(s) {
    try {
        console.log(s.split("").reverse().join("")) 
    } catch(e){
        console.log(e.message);
        console.log(s);
    }
}

function regexVar() {
    //  ^ => first item matches:
    // () => stores matching value captured within
    // [aeiou] => matches any of the characters in the brackets
    // . => matches any character:
    // + => for 1 or more occurrances (this ensures str length > 3)
    // \1 => matches to previously stored match. 
        // \2 looks for matched item stored 2 instances ago 
        // \3 looks for matched item stored 3 ago, etc

    //  $ ensures that matched item is at end of the sequence
    let re = /^([aeiou]).+\1$/;
    return re;
}

function vowelsAndConsonants(s) {
    let vowels = ["a", "e", "i", "o", "u"];

    for(let v of s) {
        if(vowels.includes(v))
            console.log(v);
    }
    
    for(let v of s) {
        if(!vowels.includes(v))
            console.log(v);
    }
}

function factorial(n) {
    if(n == 0){
        return 1;
    }
    return n * factorial(n - 1);
}

function arithmeticOperators() {
    const length = +(readLine());
    const width = +(readLine());
    
    console.log(getArea(length, width));
    console.log(getPerimeter(length, width));
}

function getPerimeter(length, width) {
    let perimeter;
    perimeter = 2 * (length + width);
    return perimeter;
}

function getArea(length, width) {
    let area;
    area = length * width;
    return area;
}

function performOperation() {
    const secondInteger = readLine();
    const secondDecimal = readLine();
    const secondString = readLine();

    const firstInteger = 4;
    const firstDecimal = 4.0;
    const firstString = 'HackerRank ';

    console.log(firstInteger + parseInt(secondInteger));
    console.log(firstDecimal + parseFloat(secondDecimal));
    console.log(firstString + secondString);    
}

function greeting() {
    const parameterVariable = readLine();
    console.log('Hello, World! \n' + parameterVariable);
}