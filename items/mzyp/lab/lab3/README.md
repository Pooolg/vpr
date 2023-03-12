# Лабораторная работа #3

## Материалы

* [Методические указания I семестр.doc](../%D0%9C%D0%B5%D1%82%D0%BE%D0%B4%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B5%20%D1%83%D0%BA%D0%B0%D0%B7%D0%B0%D0%BD%D0%B8%D1%8F%20I%20%D1%81%D0%B5%D0%BC%D0%B5%D1%81%D1%82%D1%80.doc)

## Варианты заданий
Дан массив из десяти знаковых чисел (слов или байт). Требуется:

1.	Найти количество отрицательных чисел. Массив байт.
2.	Найти сумму всех положительных и отрицательных чисел. Массив слов. 
3.	Найти сумму абсолютных величин. массив байт.
4.	Найти количество положительных чисел. Массив байт.
5.	Поменять местами пары соседних чисел. Массив слов.
6.	Переставить числа в обратном порядке. Массив байт.
7.	Заменить все отрицательные числа нулями. Массив байт.
8.	Найти среднее арифметическое чисел. Массив слов.
9.	Найти количество чисел больших 10h. Массив слов.
10.	Найти наименьшее по абсолютной величине числа. Массив байт.
11.	Найти наибольшее отрицательное число. Массив байт.
12.	Найти произведение положительных элементов последовательности. Массив слов.
13.	Найти среднее арифметическое квадратов ненулевых элементов по-следовательности. Массив слов.
14.	Найти полусумму наибольшего и наименьшего чисел. Массив байт.
15.	Найти среднее арифметическое отрицательных элементов последо-вательности. Массив слов.
16.	Найти сколько в массиве чисел больше 12h и меньше 0Afh. Массив байт.
17.	Найти есть ли в массиве два нуля, идущих подряд. Массив слов.
18.	Найти сумму абсолютных величин, меньших 6. Массив байт.
19.	Найти среднее арифметическое чисел больших 10. Массив слов.
20.	Найти сколько чисел равно 12h. Массив байт.
21.	Заменить все отрицательные числа их модулями. Массив байт.
22.	Найти среднее арифметическое положительных чисел. Массив слов.
23.	Найти количество чисел меньших 10h. Массив байт.
24.	Найти наименьшее среди положительных чисел. Массив слов.
25.	Найти наибольшее отрицательное число. Массив байт.

## Работа
##### Вариант 2: Найти сумму всех положительных и отрицательных чисел. Массив слов. 
```asm
data segment
    array dw 10,0,12,479,-347,40,50,70,124,97
    positive dw ?
    negative dw ? 
data ends     

code segment
    assume cs: code, ds: data  
    
start:
    mov ax, data
    mov ds, ax
    
    lea bx, array   ; адрес начала массива
    mov cx, 10      ; количество элементов массива
    xor ax, ax      ; обнуляем регистр суммы положительных чисел
    mov dx, ax      ; обнуляем регистр суммы отрицательных чисел
    
beg: 
    mov ax, [bx]    ; загружаем очередное слово в регистр AX
    test ax, 8000h  ; проверяем знак числа
    jns posit       ; если число положительное, переходим на метку posit
    
    neg ax          ; инвертируем знак числа
    add dx, ax      ; добавляем значение к сумме отрицательных чисел
    jmp next
    
posit:
    add ax, positive ; добавляем значение к сумме положительных чисел
    
next:
    add bx, 2       ; переходим к следующему элементу массива
    loop beg        ; продолжаем цикл до тех пор, пока не обойдем все элементы
    
    mov positive, ax ; сохраняем сумму положительных чисел в переменную positive
    mov negative, dx ; сохраняем сумму отрицательных чисел в переменную negative
    
    ; здесь можно вывести результаты
    
quit:
    mov ax, 4c00h 
    int 21h
code ends
end start
```

##### Вариант 5: Поменять местами пары соседних чисел. Массив слов.
```asm
data segment
    
    max dw ?
    mass dw 10,24,76,79,47,81,67,70,124,97

data ends  

code segment
    assume cs: code, ds: data  
    
    start:
        mov ax, data
        mov ds, ax
        
  		lea bx, mass
  		
 		mov cx, 5  
 		
  	beg:
  	    mov ax, [bx] ; tmp1 = bx[1]
  	    inc bx
  	    inc bx       ; make bx[2]
  	    mov dx, [bx] ; tmp2 = bx[2]
  	    
  	    mov [bx], ax ; bx[2] = tmp1
  	    dec bx
  	    dec bx       ; make bx[1]
  	    mov [bx], dx ; bx[1] = tmp2
  	    
  	    
  	    ;;; for debug.
  	       
  	    mov ax, [bx]
  	    inc bx
  	    inc bx
  	    
  	    mov dx, [bx]
  	    dec bx
  	    dec bx   
  	       
  	    ;;;
  	    
  	    
  	    inc bx
  	    inc bx
  	    inc bx
  	    inc bx       ; next -> bx[3]
  	    
        
 	no: 
		loop beg 
		
		
 	quit:
 	    mov ax,4C00h 	
        int 21h 	
    
code ends

end start
```

## Вопросы

1.	Для чего нужен префикс ptr ?
2.	В чем отличие команд mov ax, offset mass и lea ax, mass?
3.	В чем отличие команд mov ax, bx и mov ax, [bx]?
4.	В чем отличие команд mov ax, [bp] и mov ax, [bx]?
5.	В чем отличие команд mov ax, [bx+2] и mov ax [bx] + 2?
6.	В чем отличие команд mov ax, [bx][si] и mov ax, [si][bx]?
7.	Какие существуют разновидности инструкции jmp?
8.	Как организовать межсегментную передачу управления?
9.	Напишите фрагмент программы условного перехода к метке, лежащей от самого перехода на расстоянии 257 байт.
10.	Для организации каких вычислений служат каманды loop, loope, loopne?
11.	Модифицирует ли какие-нибудь регистры команда loop?
12.	Можно ли организовать цикл по счетчику, не используя команды loop? 
13.	Можно ли организовать цикл while с помощью одной из команд loop? 

*Авторство: **Бояршинов Н.О***