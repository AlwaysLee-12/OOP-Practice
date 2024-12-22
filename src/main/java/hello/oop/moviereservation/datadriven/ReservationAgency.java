package hello.oop.moviereservation.datadriven;

public class ReservationAgency {
    //모든 데이터 클래스들 조합 후 영화를 예매하는 클래스(데이터 중심으로 설계하고 -> 데이터 중심 설계 구현 내용 개선하고 -> 책임 중심 설계와 비교하며 데이터 중심 설계 한계 확인)
    //캡슐화, 응집도, 결합도를 기준으로 책임 중심 설계와 데이터 중심 설계 비교
    //캡슐화 : 변경 가능성 높은 부분을 객체 내부로 숨기는 추상화 기법
    //응집도 : 변경 발생 시 모듈 내에서 발생하는 변경의 정도
    //결합도 : 한 모듈이 변경되기 위해 다른 모듈의 변경을 요구하는 정도
    //캡슐화의 정도가 객체의 응집도와 결합도를 결정한다

    /**
     * 데이터 중심 설계
     * 캡슐화 위반 - getter, setter의 사용으로 객체 내부 상태 정보를 노골적으로 드러냄
     * 높은 결합도 - 객체 내부의 구현이 객체의 인터페이스에 드러나 클라이언트가 구현에 강하게 결합되어 있음(내부 구현 변경 -> 클라이언트 변경)
     * 낮은 응집도 - 어떤 요구사항 변경을 구용하기 위해 하나 이상의 클래스를 수정해야 함(SRP 위반. 클래스는 단 한 가지의 변경 이유만 가져야 한다)
     */
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Money fee = screening.calculateFee(audienceCount);

        return new Reservation(customer, screening, fee, audienceCount);
    }
}
