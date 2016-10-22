package ua.goit.thirdmodone;

public interface Semaphore {
    // Запрашивает разрешение. Если есть свободное захватывает его.
    // Если нет - приостанавливает поток до тех пор пока не появится свободное разрешение.
    void acquire() throws InterruptedException;

    // Запрашивает переданое количество разрешений. Если есть переданое количество свободных разрешений захватывает их.
    // Если нет - приостанавливает поток до тех пор пока не появится переданое количество свободных разрешений.
    void acquire(int permits) throws InterruptedException;

    // Отпускает разрешение возвращая его семафору.
    void release() throws InterruptedException;

    // Отпускает переданое количество разрешений возварщая их семафору.
    void release(int permits) throws InterruptedException;

    // Возвращает количество свободных разрешений на данный момент.
    int getAvailablePermits();
}
