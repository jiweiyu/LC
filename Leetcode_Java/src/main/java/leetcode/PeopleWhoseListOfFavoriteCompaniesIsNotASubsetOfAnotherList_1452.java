package leetcode;
import java.util.*;
public class PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList_1452 {

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies){
        List<Set<String>> favoriteCompaniesSet = new ArrayList<>();

        for(List<String> person : favoriteCompanies){
            Set<String> companies = new HashSet(person);
            favoriteCompaniesSet.add(companies);
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<favoriteCompaniesSet.size();i++){
            boolean isSubSet = false;
            for(int j=0; j<favoriteCompaniesSet.size();j++){
                Set set1 = favoriteCompaniesSet.get(i);
                Set set2 = favoriteCompaniesSet.get(j);
                if(i!=j && set2.size()>set1.size() && set2.containsAll(set1)){
                    isSubSet=true;
                    break;
                }
            }
            if(!isSubSet) res.add(i);
        }
        return res;
    }


}
