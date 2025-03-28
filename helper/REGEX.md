### Основные символы:
- . (точка) - любой символ
- \d - любая цифра (0-9)
- \w - любая буква или цифра (a-z, A-Z, 0-9, _)
- \s - пробельный символ

### Квантификаторы:
- ноль или больше повторений
- один или больше повторений
- ? - ноль или один повторение
- {n} - ровно n повторений
- {n,m} - от n до m повторений

### Границы:
^ - начало строки
$ - конец строки
\b - граница слова

### Классы символов:
[abc] - любой из указанных символов
[a-z] - диапазон символов
[^abc] - любой символ, кроме указанных

### Группировка:
( ) - группировка
(?: ) - незахватывающая группа
| - альтернатива (или)

### Экранирование специальных символов:
{ } . * + ? $ ^ |

### Полезные шаблоны:
\bword\b - целое слово
^pattern$ - строка целиком
pattern1|pattern2 - либо pattern1, либо pattern2

### Модификаторы:
Pattern.CASE_INSENSITIVE - игнорирование регистра
Pattern.MULTILINE - многострочный режим (^ и $ соответствуют началу и концу каждой строки)
Pattern.DOTALL - точка (. ) соответствует всем символам, включая newline

### Для работы с regex в Java используйте классы:
java.util.regex.Pattern
java.util.regex.Matcher

### Основные методы:
Pattern.compile(String regex) - создание паттерна
matcher(String input) - создание матчер для входной строки
matches() - полное совпадение
find() - поиск подстроки
group() - получение захваченной группы