package ru.geekbrains.lesson1_J2;


class MyArray{

    private static final int size = 10000000;
    private static final int h = size / 2;
    private float[] arr = new float[size];
    private long b;

    MyArray() {
        firstMyArray();
        changeMyArray();
    }

    private void firstMyArray(){
        for(int i=0; i < arr.length; i++){
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for(int i = 0; i<arr.length;i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        b = System.currentTimeMillis();

        System.out.println("Вычисление первого метода " + (b - a));
    }

    private synchronized void changeMyArray (){

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        long d = System.currentTimeMillis();
        System.out.println("Деление массива на два массива " + (d - b));

        for(int i = 0; i < a1.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long e = System.currentTimeMillis();
        System.out.println("Вычисление первого массива " + (e - d));
        for(int i = 0; i < a2.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long f = System.currentTimeMillis();
        System.out.println("Вычисление второго массива " + (f - e));

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        long g = System.currentTimeMillis();
        System.out.println("Склейка массива в один " + (g - f));

        System.out.println("Время выполения второго метода" + (System.currentTimeMillis() - b));
    }
}
