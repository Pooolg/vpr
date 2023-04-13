package Task9;

import java.util.ArrayList;

public class GraphShower {
    public static void showFuncs(Graph graph){
        for(int i = 0;i<graph.getFuncs().size();i++){
            System.out.println("������� "+(i+1)+"\t���: "+graph.getExplanation().getName(i));
        }
    }
    public static void showCoordinateMesh(Graph graph){
        System.out.println("������� ����: "+graph.getCoordinateMesh().getPosition());
        for(int i = 0;i<graph.getCoordinateMesh().getAxesNum();i++){
            System.out.println("����������� ���: "+graph.getCoordinateMesh().getAxisDesignation(i)+"\t�������� ���: "+graph.getCoordinateMesh().getAxisInterval(i));
        }
    }
    public static void showMesh(Graph graph){
        System.out.println("�������� �����: "+graph.getMesh().getInterval());
    }
    public static void showExplanation(Graph graph){
        for(int i = 0;i<graph.getFuncs().size();i++){
            System.out.println("��� �������: "+graph.getExplanation().getName(i)+"\t���� �������: "+graph.getExplanation().getColor(i));
        }
    }
}
