# Лабораторная работа #7 - Файловая структура системы GNU/LINUX

## Материалы

- [Laboratornayaya_rabota7_AdmLinux_FS.pdf](./Laboratornayaya_rabota6_AdmLinux_FS%20(2).pdf)


## Работа

#### 1. Ознакомиться c файловой структурой ОС Ubutnu
Найти и увидеть содержимое каталогов, соответствующих HFS. Изучить функциональность
и синтаксис записи команд манипуляций c файлами: `rm`, `rmlink`, `touch`, `mkdir`,
`cp`, `mv`,`>`,`<`,`>>`,`<<`.

Файловая структура Ubuntu основана на стандарте Файловой системы иерархии (**Filesystem Hierarchy Standard** - **FHS**), который определяет расположение файлов и каталогов в системе.

- `rm`: команда используется для удаления файлов или каталогов. Например, `rm file.txt` удаляет файл `file.txt`. Опция `-r` используется для удаления каталога и его содержимого: `rm -r directory`.

- `rmlink`: команда используется для удаления символической ссылки. Например, `rmlink linkname` удаляет символическую ссылку с именем `linkname`.

- `touch`: команда создает пустой файл или изменяет дату изменения файла. Например, `touch file.txt` создает пустой файл с именем `file.txt`, а `touch -t 202104271500 file.txt` изменяет дату изменения файла на `15:00 27 апреля 2021 года`.

- `mkdir`: команда создает новый каталог. Например, `mkdir new_directory` создает новый каталог с именем `new_directory`.

- `cp`: команда копирует файлы или каталоги из одного места в другое. Например, `cp file.txt directory` копирует файл `file.txt` в каталог `directory`. Опция `-r` используется для копирования каталога и его содержимого: `cp -r directory new_directory`.

- `mv`: команда перемещает файлы или переименовывает их. Например, `mv file.txt directory` перемещает файл `file.txt` в каталог `directory`, а `mv file.txt newname.txt` переименовывает файл file.txt в newname.txt.

- `>`: команда перенаправляет вывод команды в файл. Например, `ls > file.txt` записывает результат команды `ls` в файл `file.txt`. Если файл уже существует, его содержимое будет перезаписано.

- `<`: команда перенаправляет содержимое файла ввода для команды. Например, `sort < file.txt` сортирует содержимое файла `file.txt`.

- `>>`: команда перенаправляет вывод команды в конец файла. Например, `echo "Hello" >> file.txt` добавляет строку "Hello" в конец файла `file.txt`.

- `<<`: команда позволяет ввести ввод в команду с помощью ввода пользователя. Например, `cat << EOF` позволяет пользователю ввести ввод до тех пор, пока не будет введено слово `EOF`, после чего ввод завершается.

#### 2. Используя команды, создать два текстовых файла.

```bash
touch file1.txt
touch file2.txt

```
#### 3. Объединить созданные в п.№ 2 файл и его содержимое просмотреть на экране.

Для начала заполним файлы содержимым
```bash
echo "Str1" > file1.txt
echo "Str2" > file2.txt
```

Далее объединим файлы и посмотрим что получилось:
```bash
cat file1.txt file2.txt > cool.txt
cat cool.txt
```
Вывод:
```bash
Str1
Str2
```

#### 4. Создать директорию с другим именем и переместить в нее созданные ранее файлы.
```bash
mkdir some
mv file1.txt file2.txt some
```
#### 5. Вывести полную информацию обо всех файлах и проанализировать уровни доступа, дешифровав маски доступа.
```bash
ls -l some 
```

Вывод:
```bash
-rw-r--r-- 1 jkearnsl jkearnsl 5 апр 28 12:30 file1.txt
-rw-r--r-- 1 jkearnsl jkearnsl 5 апр 28 12:30 file2.txt
```

#### 6. Добавить для всех трех файлов право выполнения членам группы и остальным пользователям.
```bash
mv cool.txt some
chmod go+x some/cool.txt  
chmod go+x some/file1.txt                                                                        ✔ 
chmod go+x some/file2.txt 
```
#### 7. Просмотреть атрибуты файлов.
```bash
ls -l some
```

Вывод:
```bash
-rw-r-xr-x 1 jkearnsl jkearnsl 10 апр 28 12:34 cool.txt
-rw-r-xr-x 1 jkearnsl jkearnsl  5 апр 28 12:30 file1.txt
-rw-r-xr-x 1 jkearnsl jkearnsl  5 апр 28 12:30 file2.txt
```
#### 8. Создать еще один каталог с другим именем.
```bash
mkdir some2
```
#### 9. Установить дополнительную связь объединенного файла c новым каталогом, но под другим именем.
```bash
ln some/cool.txt some2/new_hardlink

```
#### 10. Создать символическую связь.
```bash
ln -s some/cool.txt some2/new_link
```
#### 11. Сделать текущим новый каталог и вывести на экран расширенный список информации o его файлах.
```bash
cd some2
ls -l
```

Вывод:
```bash
-rw-r-xr-x 2 jkearnsl jkearnsl 10 апр 28 12:34 new_hardlink
lrwxrwxrwx 1 jkearnsl jkearnsl 13 апр 28 13:08 new_link -> some/cool.txt
```

#### 12. Произвести поиск заданной последовательности символов в файлах текущей директории и получить перечень соответствующих файлов. (одной командой)
```bash
grep -r "Str" .
```

Вывод:
```bash

./new_hardlink:Str1
./new_hardlink:Str2
```

#### 13. Получить информацию об активных процессах и именах других пользователей.
```bash
ps aux
```

#### 14. Вывести на экран список файлов текущего каталога в краткой и расширенной форме.
```bash
>> ls
new_hardlink  new_link

```

```bash
>> ls -l
-rw-r-xr-x 2 jkearnsl jkearnsl 10 апр 28 12:34 new_hardlink
lrwxrwxrwx 1 jkearnsl jkearnsl 13 апр 28 13:08 new_link -> some/cool.txt

```

#### 15. Изменить текущий каталог на корневой «/».
```bash
cd /
```
#### 16. Записать в файл $HOME/filelist.lst список каталогов в каталоге /.
```bash
ls -l >> $HOME/filelist.lst 
```
#### 17. Вернуться в домашний каталог и вывести рекурсивный список всех (в т.ч. и скрытых) файлов и каталогов.
```bash
cd ~
ls -l --all
```
#### 18. В домашнем каталоге ($) создать подкаталоги src, dst и temp.
```bash
cd sometrash
mkdir src                                                                                     
mkdir temp                                                                                  
mkdir dst
```
#### 19. В каталоге src создать текстовый файл f1 произвольного содержания.
```bash
echo "some text" >> src/f1 
```
#### 20. В каталог src скопировать файлы user.txt, root.txt и stud.txt. Проверить, все ли файлы удалось скопировать.
??? откуда файлы взять эти

#### 21. В каталоге dst создать "жесткие" ссылки на все файлы из каталога src .
```bash
ln src/f1 dst/hard_f1_link
```

#### 22. В домашнем каталоге создать "мягкие" ссылки на файлы из каталога src .
```bash
cd ~
ln -s src/f1 soft_f1_link 
```
#### 23. Вывести рекурсивно расширенную информацию o содержимом домашнего каталога. Обратить внимание на поле размера для созданных ранее файлов и ссылок.

```bash
ls -Rl ~/sometrash
```
#### 24. Из домашнего каталога выполнить команды: cat /src/f1; cat /dst/f1; cat /f1. Запомнить результаты выполнения команд.
```bash
>> cat src/f1
some text
>> cat dst/hard_f1_link                                                                           
some text
>> cat soft_f1_link                                                                               
some text
```     
#### 25. Переместить файл f1 из каталога src в каталог temp и повторить п.24.
```bash
>> mv src/f1 temp                                                                               
>> cat src/f1                                                                                    
cat: src/f1: Нет такого файла или каталога
>> cat soft_f1_link                                                                             
cat: soft_f1_link: Нет такого файла или каталога
>> cat dst/hard_f1_link                                                                        
some text
```

#### 26. Удалить файл f1
```bash
>> rm temp/f1
>> cat dst/hard_f1_link 
some text
>> cat soft_f1_link
cat: soft_f1_link: Нет такого файла или каталога
```

Вывод:

При удалении файла из файловой системы, удаляется только запись об этом файле в каталоге, но сам файл на жестком диске остается нетронутым до тех пор, пока все ссылки на него не будут удалены.

Хардлинк - это еще одна ссылка на файл, которая указывает на ту же самую физическую область на диске. Когда файл удаляется, удаляется только запись о нем в каталоге, но физическая область на диске, на которую ссылается хардлинк, не удаляется, потому что она может быть использована другой ссылкой на этот же файл.

Таким образом, хардлинк продолжает хранить значение файла после его удаления, потому что он по-прежнему указывает на ту же физическую область на диске, которая содержит данные файла. Если все ссылки на файл будут удалены, то только тогда физическая область на диске будет помечена как свободная и может быть использована для хранения других данных.
