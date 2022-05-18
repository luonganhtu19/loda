# Java core
16-05-2022
1. Tight-coupling and loosely coupled
tight-coupling: Liên kết ràng buộc.
loosely-coupling: làm giảm bớt sự phụ thuộc giữ các class.
17-05-2022
2. Dependency Injection(DI) and IoC
2.1 DI
Là một design pattern. Là việc các Object nên phụ thuộc vào lớp Abtract class và thể hiện chi tiết của nó sẽ được inject
vào đối tượng trong lúc runntime.
Ví dụ:
Class:  Girls :{
            private Outfit outfit;
            public Girls(Outfit anything){
                this.outfit = anything;
            }
        }
Interface Outfit: {
        private void wear();
        }
class Bikini implement Outfit{
        public void wear() {
            System.out.println("Đã mặc Bikini");
          }
        }

        Các cách Inject dependency:
        _ Constructor Injection.
        _ Setter Injection.
        _ Interface Inject.()
        Ví dụ: Khi muốn inject vào class thì ta phải tạo ra một interface chứa hàm(kiểu thay vì gọi setter hay set ở
        Constructor) để inject(set hàm vào) trong class.

2.2 IoC:
_ Tác dụng: Mở rộng code. Giảm bớt sự phụ thuộc của các dependency. Ví dụ một class có hàng chục dependency thì sẽ rất khó
Vì vậy chúng ta cần: Chúng ta cần định nghĩa trước, sau đó tống vào và giao cho 1 thằng quản lý(framework).
IOC: Inversion of Control is a programming principle. flow of control within the application is not controlled by the application
itself, but rather by the underlying framework
 _
3. Java Bean:
    3.1 Kiến thức bổ trợ:
        3.1.1 Java reflection là một core packge trong thư viện chuẩn của Java. Mục đích của nó cho phép chúng ta truy cập vào gần như mợ thứ
        bên trong đối tượng bên trong đối tượng.
        Java reflection cho phép đánh giá, và sửa đổi cấu trúc và hành vi của một đối tượng tại thời gian chạy runtime của chương trình
        Đồng thời cho phép bạn truy cập vào các thành viên private (private member) tại mọi nơi trong ứng dụng
        3.1.2 Cách sử dụng:
            1. Lấy Field:
            Option<> girl.getClass().getDeclaredFields();
             Field nameField = girl.getClass().getDeclaredField("name");
            2. Lấy Method:
            Method[] methods = girlClass.getDeclaredMethods();
            Method methodSetName = girlClass.getMethod("setName", String.class);
            3. Lấy ra constructor:
            Constructor<Girl> girlConstructor = girlClass.getConstructor(String.class);
                    Girl girl2 = girlConstructor.newInstance("Hello");
            4. Lấy ra annotation trên field, Method, class
             Class<Girl> girlClass = Girl.class;
                    System.out.println("Class: "+girlClass.getSimpleName()); // Lấy ra tên Class
                    for(Annotation annotation : girlClass.getDeclaredAnnotations()){
                        System.out.println("Annotation: " + annotation.annotationType()); // Lấy ra tên các Annatation trên class này
                    }

                    for(Method method: girlClass.getDeclaredMethods()){ // Lấy ra các method của class
                        System.out.println("\nMethod: " + method.getName()); //Tên method
                        for(Annotation annotation : method.getAnnotations()){
                            System.out.println("Annotation: " + annotation.annotationType()); // Lấy ra tên các Annatation trên method này
                        }
                    }

