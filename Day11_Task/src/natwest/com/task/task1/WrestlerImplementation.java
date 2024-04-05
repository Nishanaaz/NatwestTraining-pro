package natwest.com.task.task1;

import natwest.com.task.task1.Wrestler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WrestlerImplementation {
    public int countAllWrestler(ArrayList<Wrestler> wrestlers){
        int count = wrestlers.size();
        return count;
    }
    public List<Wrestler> findAlltheNameStartsWithS(ArrayList<Wrestler> wrestlers){
        List<Wrestler> wrestlers1 = wrestlers.stream().filter(e->e.getName().startsWith("S")).collect(Collectors.toList());
        return wrestlers1;
    }

    public long countOfAllWrestlerWhoseWeightIsGreaterThan200(ArrayList<Wrestler> wrestlers){
        long count = wrestlers.stream().filter(w->w.getWeight()>200).count();
        return count;
    }

    public List<Wrestler> displayAllWrestlerInAscendingWhoseWeightGreaterThan150(ArrayList<Wrestler> wrestlers){
        List<Wrestler> wrestlers1 = wrestlers.stream().filter(w->w.getWeight()>150).sorted(Comparator.comparingInt(Wrestler::getWeight)).collect(Collectors.toList());
        return wrestlers1;
    }

    public List<Wrestler> displayAllWrestlerBaseOnHeightInDescendingOrder( ArrayList<Wrestler> wrestlers){
        List<Wrestler> wrestlers1 = wrestlers.stream().sorted(Comparator.comparingInt(Wrestler::getHeight).reversed()).collect(Collectors.toList());
        return wrestlers1;
    }
}
