# OOP-Practice

### 책임 주도 설계
---
데이터 중심의 설계는 데이터를 고립시킨 채 오퍼레이션을 정의하도록 하여, 객체의 인터페이스에 구현이 노출되어 있어 결합도가 높고 응집도가 낮은 코드로 전락시킨다.
재사용성이 높고 유지보수성이 높은 객체지향 설계를 위해 초점을 맞추어야 하는 것은 데이터가 아닌 외부에 제공하는 행동이다.
클라이언트 관점에서의 객체가 수행하는 행동이란 곧 객체의 책임을 의미한다.
객체에게 적절한 책임을 할당하기 위해서는 협력이라는 문맥을 고려해야 한다.
협력이라는 문맥에서의 적절한 책임은 클라이언트 관점에서의 적절한 책임이다.
클라이언트 관점에서의 적절한 책임은 메세지 전송 의도에 적합한 책임 할당이다. 
올바른 객체지향 설계는 클라이언트가 전송할 메세지를 결정이 선제되어야 한다.

**GRASP(General Responsibility Assignment Software Pattern)**
- 도메인 개념에서 출발
  - 도메인 안에 많은 개념들이 존재하고
  - 이 도메인 개념들을 책임 할당의 대상으로 사용하면, 코드에 도메인의 개념을 주입하기 수월해짐
- 정보 전문가에게 책임 할당(Information Expert 패턴. 정보는 데이터가 아님)
  - 어플리케이션의 책임 할당
    - 클라이언트가 전송할 메세지 결정
    - 이를 수신하는데 적합한 객체를 찾아 책임 할당
    - 적합한 객체를 찾기 위해 정보 전문가 패턴 활용
    - 적절한 객체를 선정했으면, 객체가 할당된 책임을 다하기 위해 어떤 행동을 수행할지 설계
    - 이 과정에서 외부의 도움이 필요한 요소를 찾아 새로운 메세지를 결정하고, 첫 번째 과정부터 새로운 책임 할당이 필요한 객체 선정작업 반복
- 적절한 책임 할당 패턴 선택
  - 낮은 결합도와 높은 응집도(변경의 이유가 하나)를 가지는 패턴을 우선 선택하라
- 객체를 생성할 책임자 선정은 CREATOR 패턴을 활용하라
  - 생성될 객체에 대해 잘 알고 있어야 하거나 해당 객체를 사용하는 객체에서 그 객체를 생성한다

