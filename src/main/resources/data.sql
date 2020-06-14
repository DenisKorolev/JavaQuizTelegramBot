INSERT INTO question (id, question, correct_answer) VALUES (1, 'Какие бывают в Java типы исключений?', 'а');
INSERT INTO answer_variant (question_id, variant) VALUES (1, 'а) Проверяемые и непроверяемые.');
INSERT INTO answer_variant (question_id, variant) VALUES (1, 'б) Проверяемые и ошибки.');
INSERT INTO answer_variant (question_id, variant) VALUES (1, 'в) Ошибки и непроверяемые.');
INSERT INTO answer_variant (question_id, variant) VALUES (1, 'г) Все ответы верны.');

INSERT INTO question (id, question, correct_answer) VALUES (2, 'Что такое ООП?', 'в');
INSERT INTO answer_variant (question_id, variant) VALUES (2, 'а) Объектно-ориентированное программирование — так ' ||
 'называют любой тип программирования, в котором используются понятия высокого уровня и, в отличие от Assembler, в ' ||
  'котором не работают напрямую с ячейками памяти ПК.');
INSERT INTO answer_variant (question_id, variant) VALUES (2, 'б) Объектно-ориентированное программирование — просто ' ||
 'красивое понятие. Если вдуматься, оно не несет дополнительной смысловой нагрузки, просто программисты любят ' ||
  'аббревиатуры, так области их знаний выглядят сложнее.');
INSERT INTO answer_variant (question_id, variant) VALUES (2, 'в) Объектно-ориентированное программирование ' ||
 '— методология программирования, основанная на представлении программы в виде совокупности объектов, каждый из ' ||
  'которых является экземпляром определенного класса, а классы образуют иерархию наследования.');
INSERT INTO answer_variant (question_id, variant) VALUES (2, 'г) Очень одинокий программист.');

INSERT INTO question (id, question, correct_answer) VALUES (3, 'Что такое класс в Java?', 'б');
INSERT INTO answer_variant (question_id, variant) VALUES (3, 'а) Уровень сложности программы. Все операторы делятся ' ||
 'на классы в зависимости от сложности их использования.');
INSERT INTO answer_variant (question_id, variant) VALUES (3, 'б) Базовый элемент объектно-ориентированного ' ||
 'программирования в языке Java.');
INSERT INTO answer_variant (question_id, variant) VALUES (3, 'в) Просто одно из возможных названий переменной.');
INSERT INTO answer_variant (question_id, variant) VALUES (3, 'г) Такое понятие есть только в C++, в Java такого' ||
 ' понятия нет.');

INSERT INTO question (id, question, correct_answer) VALUES (4, 'Как объявить класс в коде?', 'а');
INSERT INTO answer_variant (question_id, variant) VALUES (4, 'а) class MyClass {}');
INSERT INTO answer_variant (question_id, variant) VALUES (4, 'б) new class MyClass {}');
INSERT INTO answer_variant (question_id, variant) VALUES (4, 'в) select * from class MyClass {}');
INSERT INTO answer_variant (question_id, variant) VALUES (4, 'г) MyClass extends class {}');

INSERT INTO question (id, question, correct_answer) VALUES (5, 'Для чего используется оператор NEW?', 'в');
INSERT INTO answer_variant (question_id, variant) VALUES (5, 'а) Для создания новой переменной.');
INSERT INTO answer_variant (question_id, variant) VALUES (5, 'б) Для объявления нового класса.');
INSERT INTO answer_variant (question_id, variant) VALUES (5, 'в) Для создания экземпляра класса.');
INSERT INTO answer_variant (question_id, variant) VALUES (5, 'г) Это антагонист оператора OLD.');

INSERT INTO question (id, question, correct_answer) VALUES (6, 'Что обозначает исключение java.lang.ArrayIndexOutOfBoundsException?', 'б');
INSERT INTO answer_variant (question_id, variant) VALUES (6, 'а) Переполнение памяти.');
INSERT INTO answer_variant (question_id, variant) VALUES (6, 'б) Выход за рамки границ массива.');
INSERT INTO answer_variant (question_id, variant) VALUES (6, 'в) Попытку вставить в массив некорректное значение.');
INSERT INTO answer_variant (question_id, variant) VALUES (6, 'г) Переполнение стека');

INSERT INTO question (id, question, correct_answer) VALUES (7, 'Что означает ключевое слово extends?', 'а');
INSERT INTO answer_variant (question_id, variant) VALUES (7, 'а) Что данные класс наследуется от другого.');
INSERT INTO answer_variant (question_id, variant) VALUES (7, 'б) Что это дополнительный модуль класса, который расширяет его свойства.');
INSERT INTO answer_variant (question_id, variant) VALUES (7, 'в) Что два класса делают одно и то же.');
INSERT INTO answer_variant (question_id, variant) VALUES (7, 'г) Что это самый большой класс в программе.');

INSERT INTO question (id, question, correct_answer) VALUES (8, 'Что означает перегрузка метода в Java (overload)?', 'в');
INSERT INTO answer_variant (question_id, variant) VALUES (8, 'а) Изменение поведения метода класса относительно родительского.');
INSERT INTO answer_variant (question_id, variant) VALUES (8, 'б) Изменение поведения метода класса относительно дочернего.');
INSERT INTO answer_variant (question_id, variant) VALUES (8, 'в) Несколько методов с одинаковым названием, но разным набором параметров.');
INSERT INTO answer_variant (question_id, variant) VALUES (8, 'г) Несколько разных классов с одинаковым методом.');

INSERT INTO question (id, question, correct_answer) VALUES (9, 'Что означает переопределение метода в Java (override)?', 'а');
INSERT INTO answer_variant (question_id, variant) VALUES (9, 'а) Изменение поведения метода класса относительно родительского.');
INSERT INTO answer_variant (question_id, variant) VALUES (9, 'б) Изменение поведения метода класса относительно дочернего.');
INSERT INTO answer_variant (question_id, variant) VALUES (9, 'в) Несколько методов с одинаковым названием, но разным набором параметров.');
INSERT INTO answer_variant (question_id, variant) VALUES (9, 'г) Несколько разных классов с одинаковым методом.');

INSERT INTO question (id, question, correct_answer) VALUES (10, 'Чем отличаются static-метод класса от обычного метода класса?', 'в');
INSERT INTO answer_variant (question_id, variant) VALUES (10, 'а) Обычный метод класса можно перегрузить, а static-метод нельзя.');
INSERT INTO answer_variant (question_id, variant) VALUES (10, 'б) Обычный метод класса можно переопределить, а static-метод нельзя.');
INSERT INTO answer_variant (question_id, variant) VALUES (10, 'в) Обычный метод класса работает от объекта класса, а static-метод от всего класса.');
INSERT INTO answer_variant (question_id, variant) VALUES (10, 'г) Static-метод класса можно вызывать только внутри класса, а обычный - в любой части кода.');

INSERT INTO question (id, question, correct_answer) VALUES (11, 'Можно ли вызвать static-метод внутри обычного?', 'г');
INSERT INTO answer_variant (question_id, variant) VALUES (11, 'а) Нет, static-метод можно вызвать только от объекта класса.');
INSERT INTO answer_variant (question_id, variant) VALUES (11, 'б) Можно, надо перед этим перегрузить обычный метод класса.');
INSERT INTO answer_variant (question_id, variant) VALUES (11, 'в) Можно, надо перед этим переопределить обычный метод класса.');
INSERT INTO answer_variant (question_id, variant) VALUES (11, 'г) Можно, ничего дополнительно делать не надо.');

INSERT INTO question (id, question, correct_answer) VALUES (12, 'Можно ли вызвать обычный метод класса внутри static-метода?', 'а');
INSERT INTO answer_variant (question_id, variant) VALUES (12, 'а) Нет, static-метод не работает с объектом класса.');
INSERT INTO answer_variant (question_id, variant) VALUES (12, 'б) Можно, надо перед этим перегрузить обычный метод класса.');
INSERT INTO answer_variant (question_id, variant) VALUES (12, 'в) Можно, надо перед этим переопределить обычный метод класса.');
INSERT INTO answer_variant (question_id, variant) VALUES (12, 'г) Можно, ничего дополнительно делать не надо.');

INSERT INTO question (id, question, correct_answer) VALUES (13, 'Для чего необходимо ключевое слово this?', 'б');
INSERT INTO answer_variant (question_id, variant) VALUES (13, 'а) Это указатель на переопределенный метод класса. ' ||
 'Его нельзя опускать при вызове, иначе переопределение не сработает.');
INSERT INTO answer_variant (question_id, variant) VALUES (13, 'б) Это указатель на текущий объект класса внутри ' ||
 'самого класса. Его можно опускать при вызове метода класса.');
INSERT INTO answer_variant (question_id, variant) VALUES (13, 'в) Это не ключевое слово.');
INSERT INTO answer_variant (question_id, variant) VALUES (13, 'г) Это ключевое слово для вызова обычного метода ' ||
 'внутри static-метода. Его нельзя опускать, иначе вызов не сработает и будет ошибка.');

INSERT INTO question (id, question, correct_answer) VALUES (14, 'Что вернет метод, объявленный следующим образом: ' ||
 'public static int getAmount()?', 'г');
INSERT INTO answer_variant (question_id, variant) VALUES (14, 'а) Не ясно, надо смотреть код метода.');
INSERT INTO answer_variant (question_id, variant) VALUES (14, 'б) Вернет static-поле класса.');
INSERT INTO answer_variant (question_id, variant) VALUES (14, 'в) Вернет ссылку на объект класса this.');
INSERT INTO answer_variant (question_id, variant) VALUES (14, 'г) Вернет целочисленное значение.');

INSERT INTO question (id, question, correct_answer) VALUES (15, 'Можно ли динамически менять размер массива?', 'б');
INSERT INTO answer_variant (question_id, variant) VALUES (15, 'а) Да, в любом случае.');
INSERT INTO answer_variant (question_id, variant) VALUES (15, 'б) Нет.');
INSERT INTO answer_variant (question_id, variant) VALUES (15, 'в) Да, если использовался оператор new.');
INSERT INTO answer_variant (question_id, variant) VALUES (15, 'г) Да, если использовался декоратор dynamic.');

INSERT INTO question (id, question, correct_answer) VALUES (16, 'Из какой структуры данных "сборщик мусора" удалит ' ||
 'все элементы у которых исчезла последняя ссылка на их ключ в этой структуре?', 'в');
INSERT INTO answer_variant (question_id, variant) VALUES (16, 'а) HashMap');
INSERT INTO answer_variant (question_id, variant) VALUES (16, 'б) LinkedHashMap');
INSERT INTO answer_variant (question_id, variant) VALUES (16, 'в) WeakHashMap');
INSERT INTO answer_variant (question_id, variant) VALUES (16, 'г) IdentityHashMap');

INSERT INTO question (id, question, correct_answer) VALUES (17, 'Как вручную вызвать сборщик мусора в Java?', 'в');
INSERT INTO answer_variant (question_id, variant) VALUES (17, 'а) Вызвать Runtime.getRuntime().gc()');
INSERT INTO answer_variant (question_id, variant) VALUES (17, 'б) Вызвать метод finalize() у объекта.');
INSERT INTO answer_variant (question_id, variant) VALUES (17, 'в) Это нельзя сделать вручную.');
INSERT INTO answer_variant (question_id, variant) VALUES (17, 'г) Вызвать деструктор у объекта.');

INSERT INTO question (id, question, correct_answer) VALUES (18, 'Каой размер у переменной типа short?', 'б');
INSERT INTO answer_variant (question_id, variant) VALUES (18, 'а) 8 бит');
INSERT INTO answer_variant (question_id, variant) VALUES (18, 'б) 16 бит');
INSERT INTO answer_variant (question_id, variant) VALUES (18, 'в) 32 бита');
INSERT INTO answer_variant (question_id, variant) VALUES (18, 'г) 64 бита');

INSERT INTO question (id, question, correct_answer) VALUES (19, 'Какое из следующих слов не является ключевым?', 'б');
INSERT INTO answer_variant (question_id, variant) VALUES (19, 'а) static');
INSERT INTO answer_variant (question_id, variant) VALUES (19, 'б) Boolean');
INSERT INTO answer_variant (question_id, variant) VALUES (19, 'в) void');
INSERT INTO answer_variant (question_id, variant) VALUES (19, 'г) private');

INSERT INTO question (id, question, correct_answer) VALUES (20, 'Какое значение по умолчанию принимает переменная типа int?', 'а');
INSERT INTO answer_variant (question_id, variant) VALUES (20, 'а) 0');
INSERT INTO answer_variant (question_id, variant) VALUES (20, 'б) 0.0');
INSERT INTO answer_variant (question_id, variant) VALUES (20, 'в) null');
INSERT INTO answer_variant (question_id, variant) VALUES (20, 'г) Значение по умолчанию отсутствует.');

