package U3;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static public ArrayList<Producto> p1 = new ArrayList<>();
    static public ArrayList<Producto> pCustomer = new ArrayList<>();


    public static void main(String[] args) {
        // Se agregan todos los productos al iniciar el prigrama
        p1.add(new Accesorio("Funda", 150.0));
        p1.add(new Accesorio("Smart Watch", 2150.2));
        p1.add(new Accesorio("Smart Band", 500.0));
        p1.add(new Accesorio("Funda 2", 300.0));
        p1.add(new Accesorio("Teclado", 998.75));
        p1.add(new Accesorio("Mouse", 258.68));
        p1.add(new Accesorio("Cable USB", 188.0));
        p1.add(new Accesorio("Cable AUX", 158.65));
        p1.add(new Laptop("MATEBOOK D16", 25_000, "HUAWEI", "D15", 16));
        p1.add(new Smartphone("IPHONE 14 PRO MAX", 31_000, "APPLE", "IPHONE", 252));
        p1.add(new TV("SAMSUNG QLED", 10_000, "SAMSUNG", "QLED", 4));
        p1.add(new Tablet("SAMSUNG S8", 10_000, "SAMSUNG", "S", 512));
        p1.add(new Herramientas("CHUWI", 900, "SMART", "1645F", 0));
        p1.add(new Consolas("PLAY STATION 5", 10_000, "SONY", "PS5", 10));
        p1.add(new Consolas("XBOX SERIES X", 8_000, "MICROSOFT", "SERIES X", 12));

        Scanner obj = new Scanner(System.in);
        String user;
        int data = 0;

        while (data < 3) data++;

        System.out.println("""
                                   _______________________________
                          ________|   _    __   __  ___ ___ ___   |_______
                          \\       |  /_\\  (_   /     |   |   |    |      /
                           \\      | /   \\  __) \\__  _|_ _|_ _|_   |     /
                           /      |_______________________________|     \\
                          /__________)                        (__________\\
                		 \s
                """);
        System.out.println("Bienvenido a la Tienda de Electrodomesticos");
        user = printMenu(obj);
        if (user.equalsIgnoreCase("Admin")) {
            Admin(obj);
        } else User(obj);
    }

    static public String printMenu(Scanner obj) {
        String user, password;
        System.out.println();
        System.out.println("------- Iniciar Sesion ------");
        System.out.print("Usuario: ");
        user = obj.nextLine();
        System.out.print("\nIngrese su constraseña: ");
        password = obj.nextLine();
        if (user.isEmpty() || password.isEmpty()) {
            System.out.println("\n\nERROR, VUELVA A INTENTARLO\n");
            return printMenu(obj);
        }
        return user;
    }

    static public void User(Scanner obj) {
        int choose;
        double amount = 0;
        do {
            System.out.println("Bienvenido Sr Cliente!");
            System.out.println("¿Que operacion desea realizar?");
            System.out.println("1) Agregar Productos al Carrito");
            System.out.println("2) Ver Productos");
            System.out.println("3) Ver Carrito");
            System.out.println("4) Eliminar Producto");
            System.out.println("5) Salir");
            choose = obj.nextInt();
            obj.nextLine();

            switch (choose) {
                case 1 -> AgregarProductoUser(obj);
                case 2 -> VerProductos(obj);
                case 3 -> VerProductosUser(obj);
                case 4 -> EliminarProductoCarrito(obj);
                case 5 -> {
                    System.out.println("----------------- USTED ESTA SALIENDO ----------------");
                    for (Producto element: pCustomer) {
                        amount += element.getPrecio();
                    }
                    if (amount == 0.0) {System.out.println("USTED NO COMPRO NADA");}
                    else System.out.println("USED TIENE QUE PAGAR UNA CANTIDAD DE $" + amount);
                }
                default -> System.out.println("La opcion es invalida, vuelve a intentarlo");
            }
        } while (choose != 5);

    }

    static public void Admin(Scanner obj) {
        int choose;
        do {
            System.out.println("Bienvenido Sr Administrador!");
            System.out.println("¿Que operacion desea realizar?");
            System.out.println("1) Agregar Productos");
            System.out.println("2) Ver Productos");
            System.out.println("3) Eliminar Producto");
            System.out.println("4) Cambiar Producto");
            System.out.println("5) Salir");
            choose = obj.nextInt();
            obj.nextLine();

            switch (choose) {
                case 1 -> AgregarProductoAdmin(obj);
                case 2 -> VerProductos(obj);
                case 3 -> EliminarProducto(obj);
                case 4 -> CambiarProducto(obj);
                case 5 -> System.out.println("USTED ESTA SALIENDO DEL MENU");
                default -> System.out.println("La opcion es invalida, vuelve a intentarlo");
            }
        }
        while (choose != 5);
    }

    static public void AgregarProductoUser(Scanner obj) {
        System.out.println("AGREGADOR DE PRODUCTOS");
        String name;
        do {
            System.out.print("Inserte el nombre del producto: ");
            name = obj.nextLine();

            if ((name.isEmpty())) {
                System.out.println("Intentelo otra vez 1");
                continue;
            };
            for (Producto data : p1) {
                if (name.equals(data.getNombre())) {
                    pCustomer.add(data);
                    System.out.println("El producto ha sido agregado al carrito correctamente");
                    break;
                }
                else System.out.println("Ha ocuurrido un error, intentelo otra vez!");
            }

        } while (!name.contains("exit()"));
        System.out.print("\nUsted ha salido correctamente el menu de Agregar Produto\n");
    }

    static public void AgregarProductoAdmin(Scanner obj) {
        System.out.println("AGREGADOR DE PRODUCTOS");
        String name;
        double price;
        do {
            System.out.print("Inserte el nombre del producto: ");
            name = obj.nextLine();

            System.out.print("Inserte el precio del producto: ");
            price = obj.nextInt();
            obj.nextLine();

            if ((!name.isEmpty()) && price > 0 && !name.equalsIgnoreCase("exit()")) {
                p1.add(new Accesorio(name, price));
                System.out.println("Producto agragado correctamente\n");
            }
            else System.out.println("Intentelo otra vez");

        } while (!name.contains("exit()"));
        System.out.print("\nUsted ha salido correctamente el menu de Agregar Produto\n");
    }

    static public void VerProductos(Scanner obj) {
        System.out.println("INVENTARIO DE LA TIENDA");
        for (Producto element : p1) {
            System.out.println(element);
        }

        System.out.print("\nPresione CUALQUIER tecla para continuar");
        obj.nextLine();
    }

    static public void VerProductosUser(Scanner obj) {
        System.out.println("PRODUCTOS EN CARRITO");
        for (Producto element : pCustomer) {
            System.out.println(element);
        }

        System.out.print("\nPresione CUALQUIER tecla para continuar");
        obj.nextLine();
    }

    public static void EliminarProducto(Scanner obj) {
        String choose;
        System.out.println("¿Que producto desea eliminar?");
        choose = obj.nextLine();

        for (Producto element : p1) {
            if (Objects.equals(choose, element.getNombre())) {
                p1.remove(element);
                System.out.println("Elemento eliminado correctamente");
                break;
            }
        }
    }

    public static void EliminarProductoCarrito(Scanner obj) {
        String choose;
        System.out.println("¿Que producto desea eliminar?");
        choose = obj.nextLine();

        for (Producto element : pCustomer) {
            if (Objects.equals(choose, element.getNombre())) {
                pCustomer.remove(element);
                System.out.println("Elemento eliminado correctamente");
                break;
            }
        }
    }

    public static void CambiarProducto(Scanner obj) {
        String choose, new_name;
        System.out.print("¿Que producto desea cambiar el nombre?: ");
        choose = obj.nextLine();

        System.out.println("\nAhora dime el nombre: ");
        new_name = obj.nextLine();


        for (Producto element : pCustomer) {
            if (Objects.equals(choose, element.getNombre())) {
                element.setNombre(new_name);
                System.out.println("\nElemento actualizado correctamente");
                break;
            }
        }
    }
}