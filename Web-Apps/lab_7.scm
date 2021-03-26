;This function calculates the factorial of "n", where "n" is an integer argument supplied by the programmer
;Factorial, in mathematics, the product of all positive integers less than or equal to a given positive integer and denoted by that integer and an exclamation point. Thus, factorial seven is written 7!, meaning 1 × 2 × 3 × 4 × 5 × 6 × 7. Factorial zero is defined as equal to 1.
;SOURCE: Encyclopaedia Britannica 

(define (fact n) ;define function called fact, with n passed as the argument
	(if (= 0 n)		 ;if n == 0, then return 1 because 0! == 1
		1             
		(* n (fact(- n 1))) ;else, multiply "n" with a a recursive call to fact(), passing in "n-1"
	)
)

(fact 3) ;this is the function call to fact() with 3 passed in as argument.
         ;fact(3) equals 3! which equals 3 * 2 * 1 which gives us 6
