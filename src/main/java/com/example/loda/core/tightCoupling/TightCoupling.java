package com.example.loda.core.tightCoupling;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class TightCoupling {
    VeryComplexService veryComplexService = new VeryComplexService();
    private String a;
    public String TightCoupling(){
        return veryComplexService.test();
    }
}
//lvl1 ve su giang buoc cua cac class
class BubbleSortAlgorithm{
    public void sort(int[] array){
        System.out.println("sap xep noi boi");
    }
}

//lvl2
interface SortAlgorithm{
    public void sort(int array[]);
}
@Component
class BubbleSortAlgorithm1 implements SortAlgorithm{
    @Override
    public void sort(int[] array) {
        System.out.println("sap xep noi bot 26");
    }
}
//lvl3
@Service
class QuicksortAlgorithm implements SortAlgorithm {
    @Override
    public void sort(int[] array) {
        // TODO: Add your logic here
        System.out.println("Đã sắp xếp bằng thuật sx nhanh 36");

    }
}

@Data
class VeryComplexService{
    // lv1
    private BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
    public VeryComplexService(){};
    public void complexService(int array[]){
        bubbleSortAlgorithm.sort(array);
    }

    //lv2
    private SortAlgorithm sortAlgorithm;
    public VeryComplexService VeryComplexService( ){
        VeryComplexService veryComplexService = new VeryComplexService();
        veryComplexService.setSortAlgorithm(new BubbleSortAlgorithm1());
        return veryComplexService;
    }
    public void complexBusiness(int array[]){
        sortAlgorithm.sort(array);
        // TODO: more logic here
    }

    //lv3
    public VeryComplexService(SortAlgorithm sortAlgorithm){
        this.sortAlgorithm = sortAlgorithm;
    }

    // test application
    @Autowired
    ApplicationContext applicationContext;
    VeryComplexService (ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }
    public String test() {
        SortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm1();
        SortAlgorithm quickSortAlgorithm = new QuicksortAlgorithm();
        VeryComplexService bu1 = new VeryComplexService(bubbleSortAlgorithm);
        VeryComplexService bu2 = new VeryComplexService(quickSortAlgorithm);
        bu1.sortAlgorithm.sort(null);
        bu2.sortAlgorithm.sort(null);
        SortAlgorithm bubbleSortAlgorithmApp = applicationContext.getBean("bubbleSortAlgorithm",SortAlgorithm.class);
        System.out.println("---------------------------------");
        bubbleSortAlgorithmApp.sort(null);
        System.out.println("-------------------------");
        return bubbleSortAlgorithmApp.toString();
    }
}
