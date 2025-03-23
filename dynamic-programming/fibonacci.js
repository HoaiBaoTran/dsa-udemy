// 1 Can be divided into subproblem
// 2 Recursive Solution
// 3 Are there repetitive subproblems
// 4 Memoize subproblems
// 5 Demand a raise from your boss

// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233...
let slowCalculations = 0
// O(2^n) - time complexity
function fibonacci(n) {
    slowCalculations++;
    if (n < 2) {
        return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2)
}

let fastCalculations = 0
function fibonacciMaster() {
    // O(n) - time complexity
    let cache = {}
    return function fib(n) {
        fastCalculations++;
        if (n in cache) {
            return cache[n]
        }
        else {
            if (n < 2) {
                return n;
            }
            cache[n] = fib(n - 1) + fib(n - 2)
            return cache[n];
        }
    }
}

console.log('Slow: ', fibonacci(35));
console.log('we did ' + slowCalculations + ' slow calculations');

const fasterFib = fibonacciMaster();
console.log('Fast: ', fasterFib(100));
console.log('we did ' + fastCalculations + ' fast calculations');
