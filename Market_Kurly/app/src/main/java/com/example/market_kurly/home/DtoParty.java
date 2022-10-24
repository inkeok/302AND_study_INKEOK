package com.example.market_kurly.home;

import com.example.market_kurly.R;

import java.util.ArrayList;
import java.util.HashMap;

public class DtoParty {
    public HashMap<String, ArrayList<PrizeDTO>> dtoParty(){
        HashMap<String, ArrayList<PrizeDTO>> map = new HashMap<String, ArrayList<PrizeDTO>>();

        ArrayList<PrizeDTO> pop_list = new ArrayList<>();
        pop_list.add(new PrizeDTO(R.drawable.pop_01, "[홍대쭈꾸미] 쭈꾸미 볶음 300g(냉동)", true, 13, 7900));
        pop_list.add(new PrizeDTO(R.drawable.pop_02, "[KF365] 양념 소불고기 1kg (냉장)", true, 10, 18900));
        pop_list.add(new PrizeDTO(R.drawable.pop_03, "[연세우유 x 마켓컬리] 전용목장우유 900ml", false, 1, 2070));
        pop_list.add(new PrizeDTO(R.drawable.pop_04, "[KF365] DOLE 실속 바나나 1kg (필리핀)", false, 1, 3700));
        pop_list.add(new PrizeDTO(R.drawable.pop_05, "[고래사어묵] 김치 우동 전골", false, 1, 10500));
        pop_list.add(new PrizeDTO(R.drawable.pop_06, "[KF365] 1+등급 무항생제 대란 20구", false, 1, 7100));
        pop_list.add(new PrizeDTO(R.drawable.pop_07, "[다향오리] 훈제오리 슬라이스 150g (3개입)", false, 1, 9900));
        pop_list.add(new PrizeDTO(R.drawable.pop_08, "[이연복의 목란] 짬뽕 2인분", true, 7, 13500));
        pop_list.add(new PrizeDTO(R.drawable.pop_09, "[스윗밸런스] 오늘의 샐러드 8종(리뉴얼)", false, 1, 5400));
        pop_list.add(new PrizeDTO(R.drawable.pop_10, "[KF365] 방울토마토 500g", true, 5, 6000));

        map.put("pop", pop_list);

        ArrayList<PrizeDTO> al_list = new ArrayList<>();
        al_list.add(new PrizeDTO(R.drawable.al_01, "[럭키찬스] 젠티스트 투엑스 치약 100g x 5입 2종", true, 63, 26900) );
        al_list.add(new PrizeDTO(R.drawable.al_02, "[천지양] 명품 참당귀 데커신 골드 30정 (15일분)", true, 61, 59000) );
        al_list.add(new PrizeDTO(R.drawable.al_03, "[듀이트리] 어반쉐이드 모이스처 리페어선", true, 55, 13500) );
        al_list.add(new PrizeDTO(R.drawable.al_04, "[기획제품] 티 빌링 스파클링 7+1입", true, 60, 15000) );
        al_list.add(new PrizeDTO(R.drawable.al_05, "[선물세트] 대니시비키퍼스 로모섬의 꿀", true, 70, 58000) );
        al_list.add(new PrizeDTO(R.drawable.al_06, "[어바웃미] 비 클린 톤업  선크림", true, 55, 25000) );
        al_list.add(new PrizeDTO(R.drawable.al_07, "[진미식품] 우리쌀로만든 전통 장 세트", true, 50, 29900) );
        al_list.add(new PrizeDTO(R.drawable.al_08, "[풀무원] 가쓰오 메일소바 2인분", true, 56, 15000) );
        al_list.add(new PrizeDTO(R.drawable.al_09, "[기획찬스] 비비고 닭가슴살 파스타 1입", true, 60, 15500) );
        al_list.add(new PrizeDTO(R.drawable.al_10, "[지퍼포우즈] 농장 동물 초콜릿", true, 60, 25000) );

        map.put("al", al_list);

        ArrayList<PrizeDTO> vege_list = new ArrayList<>();
        vege_list.add(new PrizeDTO(R.drawable.vege_01, "그린빈스(줄기콩)", false, 1, 4600));
        vege_list.add(new PrizeDTO(R.drawable.vege_02, "[리더브래드] 베이비비트 250g", false, 1, 6400));
        vege_list.add(new PrizeDTO(R.drawable.vege_03, "친환경 노루궁뎅이 버섯 160g", false, 1, 3990));
        vege_list.add(new PrizeDTO(R.drawable.vege_04, "유채나물 150g", false, 1, 3690));
        vege_list.add(new PrizeDTO(R.drawable.vege_05, "달래 60g", true, 11, 2690));
        vege_list.add(new PrizeDTO(R.drawable.vege_06, "[달콘] 초당옥수수 1입", true, 5, 3800));
        vege_list.add(new PrizeDTO(R.drawable.vege_07, "무농약 머쉬밥 80g", false, 1, 12000));
        vege_list.add(new PrizeDTO(R.drawable.vege_08, "친환경 고사리 300g", false, 1, 11900));
        vege_list.add(new PrizeDTO(R.drawable.vege_09, "컷팅 부추 100g", true, 5, 1300));
        vege_list.add(new PrizeDTO(R.drawable.vege_10, "청도 미나리 300g", false, 1, 4990));

        map.put("vege", vege_list);

        ArrayList<PrizeDTO> new_list = new ArrayList<>();
        new_list.add(new PrizeDTO(R.drawable.new_01, "저탄소 GAP SSO농법 시나노 스위트 사과 2.5Kg", true, 5, 19900));
        new_list.add(new PrizeDTO(R.drawable.new_02, "[씨알로] 우리쌀 프레이크 490g", true, 21, 7300));
        new_list.add(new PrizeDTO(R.drawable.new_03, "[하리보] 할로윈 스케리펀 980g", false, 1, 13980));
        new_list.add(new PrizeDTO(R.drawable.new_04, "식감이 좋은 양광 사과 1.3kg", false, 1, 10900));
        new_list.add(new PrizeDTO(R.drawable.new_05, "저탄소 GAP SSO농법 시나노골드 사과 2.5Kg", true, 4, 24900));
        new_list.add(new PrizeDTO(R.drawable.new_06, "[윤슬] 남해안 가리비 500g (생물)", false, 1, 5500));
        new_list.add(new PrizeDTO(R.drawable.new_07, "[위니비니] 할로윈 미니바구니 2종", false, 1, 5500));
        new_list.add(new PrizeDTO(R.drawable.new_08, "[위니비니] 세트 투명 호박 바구니", false, 1, 14000));
        new_list.add(new PrizeDTO(R.drawable.new_09, "[언리미트] 식물성 브리또 2개입 2종", true, 5, 7500));
        new_list.add(new PrizeDTO(R.drawable.new_10, "[금미옥] 무침 군만두", false, 1, 7400));

        map.put("new", new_list);

        ArrayList<PrizeDTO> fru_list = new ArrayList<>();
        fru_list.add(new PrizeDTO(R.drawable.fru_01, "무농약 제주 청레몬 450g (3~5입)", false, 1 , 8500));
        fru_list.add(new PrizeDTO(R.drawable.fru_02, "저탄소 GAP 황금향 1Kg", false, 1 , 13900));
        fru_list.add(new PrizeDTO(R.drawable.fru_03, "칠레산 블루베리 2종", true, 10 , 6500));
        fru_list.add(new PrizeDTO(R.drawable.fru_04, "향기가득 샤인머스켓 2Kg", false, 1 , 38000));
        fru_list.add(new PrizeDTO(R.drawable.fru_05, "저탄소 GAP 루비에스 사과 650g", true, 5 , 9900));
        fru_list.add(new PrizeDTO(R.drawable.fru_06, "[황영감] 저탄소 GAP 태추단감 1Kg", false, 1 , 9900));
        fru_list.add(new PrizeDTO(R.drawable.fru_07, "냉동 간편 람부탄 750g (베트남산)", true, 8 , 12000));
        fru_list.add(new PrizeDTO(R.drawable.fru_08, "청도반시 1.5Kg (2팩)", true, 15 , 11900));
        fru_list.add(new PrizeDTO(R.drawable.fru_09, "황옥 사과 2Kg (10~12입)", false, 1 , 19900));
        fru_list.add(new PrizeDTO(R.drawable.fru_10, "남아공 자몽 960g (3입)", false, 1 , 7800));

        map.put("fru", fru_list);

        ArrayList<PrizeDTO> meat_list = new ArrayList<>();
        meat_list.add(new PrizeDTO(R.drawable.meat_01, "[미트클레버] 소갈비찜", false, 1, 35000));
        meat_list.add(new PrizeDTO(R.drawable.meat_02, "[소호好담] 1등급 한우 프리미엄 갈비세트 1호(냉동)", true, 10, 255000));
        meat_list.add(new PrizeDTO(R.drawable.meat_03, "[선물세트] 노란상소갈비 LA갈비", true, 30, 117900));
        meat_list.add(new PrizeDTO(R.drawable.meat_04, "[우리흑돈] 무항생제 흑돼지 오겹살(냉장)", false, 1, 16000));
        meat_list.add(new PrizeDTO(R.drawable.meat_05, "[우리흑돈] 무항생제 흑돼지 앞다리 300g (냉장)", false, 1, 9900));
        meat_list.add(new PrizeDTO(R.drawable.meat_06, "[Kurly's] 동물복지 유정초란 10구", false, 1, 4950));
        meat_list.add(new PrizeDTO(R.drawable.meat_07, "[Kim's butcher] 삼겹살 구이용 300g", false, 1, 6900));
        meat_list.add(new PrizeDTO(R.drawable.meat_08, "[Kim's butcher] 목살 구이용 300g", false, 1, 6600));
        meat_list.add(new PrizeDTO(R.drawable.meat_09, "[미트클레버] 한돈 떡갈비 (2개입)", false, 1, 7000));
        meat_list.add(new PrizeDTO(R.drawable.meat_10, "[한우고방] 한우 불고기 180g", true, 15, 10900));

        map.put("meat", meat_list);

        ArrayList<PrizeDTO> milk_list = new ArrayList<>();
        milk_list.add(new PrizeDTO(R.drawable.milk_01, "[연세우유 x 마켓컬리] 전용목장우유 900ml", false, 1 , 2070));
        milk_list.add(new PrizeDTO(R.drawable.milk_02, "[폴바셋] 바리스타 돌체라떼 330ml", false, 1 , 3400));
        milk_list.add(new PrizeDTO(R.drawable.milk_03, "[하이트 진로] 석수 (2L X 6개)", false, 1 , 2980));
        milk_list.add(new PrizeDTO(R.drawable.milk_04, "[서울우유] 비요뜨 요거트 5종", false, 1 , 1330));
        milk_list.add(new PrizeDTO(R.drawable.milk_05, "[마켓컬리 x 매일유업] My Basic 매일 좋은 1A우유 900mL", false, 1 , 2170));
        milk_list.add(new PrizeDTO(R.drawable.milk_06, "[서울우유] 나 100% 우유 1000mL", false, 1 , 2710));
        milk_list.add(new PrizeDTO(R.drawable.milk_07, "[YOZM] 플레인그릭요거트", false, 1 , 3900));
        milk_list.add(new PrizeDTO(R.drawable.milk_08, "[맑은물에] 참좋은 국산 흑임자 콩물 1000mL", false, 1 , 6000));
        milk_list.add(new PrizeDTO(R.drawable.milk_09, "[스타벅스] 디스커버리즈 컵커피 200mL 2종", false, 1 , 2050));
        milk_list.add(new PrizeDTO(R.drawable.milk_10, "[서울우유] 삼각 커피 우유 4개입", false, 1 , 3490));

        map.put("milk", milk_list);

        ArrayList<PrizeDTO> sea_list = new ArrayList<>();
        sea_list.add(new PrizeDTO(R.drawable.sea_01, "[해말린] 두철새우 90g", false, 1, 9900));
        sea_list.add(new PrizeDTO(R.drawable.sea_02, "[삼삼물산] 전국민이 좋아하는 통영 굴 200g", true, 11, 6900));
        sea_list.add(new PrizeDTO(R.drawable.sea_03, "꽁치 450g 내외 (3마리, 냉장)", false, 1, 4790));
        sea_list.add(new PrizeDTO(R.drawable.sea_04, "손질 삼치 500g 내외 (냉장)", true, 8, 5980));
        sea_list.add(new PrizeDTO(R.drawable.sea_05, "[제주마미] 제주바당 톳 200g X 2입 (냉동)", false, 1, 8900));
        sea_list.add(new PrizeDTO(R.drawable.sea_06, "[모현상회] 간장 새우장 200g (냉장)", false, 1, 9690));
        sea_list.add(new PrizeDTO(R.drawable.sea_07, "[모현상회] 순살 간장 전복장 200g (냉장)", false, 1, 16900));
        sea_list.add(new PrizeDTO(R.drawable.sea_08, "국산 무항생제 새우 500g (생물)", true, 25, 22900));
        sea_list.add(new PrizeDTO(R.drawable.sea_09, "[모위] 연어 스테이크 200g(냉장)", true, 10, 11500));
        sea_list.add(new PrizeDTO(R.drawable.sea_10, "[피쉬쉘] 부세조기 340g 내외 (냉동)", false, 1, 5980));

        map.put("sea", sea_list);

        return map;
    }

}
