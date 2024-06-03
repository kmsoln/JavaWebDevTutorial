## Урок 1: Введение в JMeter и базовая настройка

### Цель
Цель этого урока - познакомить вас с JMeter и провести через процесс базовой настройки, включая запуск JMeter и добавление группы потоков в ваш план тестирования.

### Шаги

#### 1.1. Запуск JMeter
![jmeter-site.png](../../../srcs/jmeter/site.png)
1. **Загрузка и установка JMeter**
   - Посетите [официальный веб-сайт JMeter](https://jmeter.apache.org/download_jmeter.cgi) и загрузите последнюю версию.
   - Распакуйте скачанный архив.
   - Перейдите в каталог `bin` и запустите JMeter, запустив файл `jmeter.bat` (Windows) или `jmeter.sh` (macOS/Linux).

#### 1.2. Добавление группы потоков
![interface.png](../../../srcs/jmeter/interface.png)
1. **Создание плана тестирования**
   - Откройте JMeter.
   - Щелкните правой кнопкой мыши на узле **План тестирования**.
     <br>![test-plan.png](../../../srcs/jmeter/test-plan.png)
   - Выберите **Добавить > Потоки (Пользователи) > Группа потоков**.
     <br>![test-plan.png](../../../srcs/jmeter/thread-group.png)
---    
# [Далее: Настройка HTTP Test Script Recorder](setting-up-http-test-script-recorder.md)