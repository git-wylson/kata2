package com.wd;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestMap {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate lacalDate1 = LocalDate.of(2016, Month.OCTOBER, 12);
		Date date1 = Date.from(lacalDate1.atStartOfDay(ZoneId.of( "Europe/Paris" )).toInstant());
		System.out.println("date : "+ date1.toString());
		
		Map<ForecastJoinKey, List<String>> map1 = new LinkedHashMap<ForecastJoinKey, List<String>>();
		ForecastJoinKey key = addkey("FN004",date1,"ANL41");
		map1.put(key, new ArrayList(Arrays.asList("FANTA")));
		
		for(int i=2;i<5;i++){			
			if(map1.containsKey(addkey("FN00"+i,date1,"ANL41"))){
				map1.get(key).add("COCA");
				 
			}else  {
				List<String> list = new ArrayList<>();
				list.add("autres valeur");
				map1.put(addkey("FN00"+(i-2),date1,"ANL41"), list);
			}
		}
		
		Map<ForecastJoinKey, List<Integer>> map2 = new LinkedHashMap<ForecastJoinKey, List<Integer>>();
		map2.put(key,Arrays.asList(23));
		map2.put(addkey("FN201",date1,"ANL41"),Arrays.asList(23,874));
		map2.put(addkey("FN999",date1,"ANL41"),Arrays.asList(85));
		
		Map<ForecastJoinKey, List<Boolean>> map3 = new LinkedHashMap<ForecastJoinKey, List<Boolean>>();
		map3.put(key,Arrays.asList(true));
		map3.put(addkey("FN201",date1,"ANL41"),Arrays.asList(false,true));
		map3.put(addkey("FN777",date1,"ANL41"),Arrays.asList(false));
		
		List<ValueObject> data = new ArrayList<>(); 
		ForecastJoinKey todelete = null;
		//map1.forEach((k,v)->{
		// for (Map.Entry<ForecastJoinKey, List<String>> entry : map1.entrySet()) {
		 Iterator<Map.Entry<ForecastJoinKey,List<String>>> iter = map1.entrySet().iterator();
		 while (iter.hasNext()) {
		     Map.Entry<ForecastJoinKey,List<String>> entry = iter.next();
		     		 
			
			System.out.println("key : " + entry.getKey() + " value : " + entry.getValue().toString());
			if(map2.containsKey(entry.getKey()) && map3.containsKey(entry.getKey())){
				System.out.println("----- 1 2 3 ");
				
				if(todelete!=null){
					iter.remove();					
					//map2.remove(map2.get(todelete));
					Map<ForecastJoinKey, List<Integer>> collect2 = map2.entrySet().stream()
			                .filter(map -> map.getKey().equals(todelete))
			                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

					Map<ForecastJoinKey, List<Boolean>> collect3 = map3.entrySet().stream()
			                .filter(map -> map.getKey().equals(todelete))
			                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
					 
				 }
			}
			else if(map2.containsKey(entry.getKey())){
				System.out.println("----- 1 2 ");
				
				if(todelete!=null){
					map1.remove(todelete);
					map2.remove(todelete);
				 }
			}else if(map3.containsKey(entry.getKey())){
				System.out.println("----- 1 3 ");
				if(todelete!=null){
					map1.remove(todelete);
					map3.remove(todelete);
				 }
			}
			
			todelete = entry.getKey();
		//});
		 }
		String stop = "";

	}

	static ForecastJoinKey addkey(String facility, Date date, String strAnl){
		ForecastJoinKey key = new ForecastJoinKey();
		key.setAnlStructure(strAnl);
		key.setEventDate(date);
		key.setFacility(facility);
		return key;
	}
}








public static String getCurrentUserLogin() {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    Authentication authentication = securityContext.getAuthentication();
    String userName = null;
    if (authentication != null) {
      if (authentication.getPrincipal() instanceof UserDetails) {
        UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
        userName = springSecurityUser.getUsername();
      } else if (authentication.getPrincipal() instanceof String) {
        userName = (String) authentication.getPrincipal();
      }
    }
    return userName;
  }

   
  public static boolean isAuthenticated() {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    Collection<? extends GrantedAuthority> authorities =
        securityContext.getAuthentication().getAuthorities();
    if (authorities != null) {
      for (GrantedAuthority authority : authorities) {
        if (authority.getAuthority().equals(AuthoritiesConstants.ANONYMOUS)) {
          return false;
        }
      }
    }
    return true;
  }

   
  public static boolean isCurrentUserInRole(String authority) {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    Authentication authentication = securityContext.getAuthentication();
    Collection<? extends GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    if (authentication != null) {
      if (authentication.getPrincipal() instanceof UserDetails) {
        UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
        authorities = springSecurityUser.getAuthorities();
      } else {
        authorities = authentication.getAuthorities();
      }
      return authorities.contains(new SimpleGrantedAuthority(authority));
    }
    return false;
  }
