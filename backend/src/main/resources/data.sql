INSERT INTO public.course_type (id, name)
VALUES (1, 'SOUP'),
       (2, 'MAIN'),
       (3, 'DESSERT');

INSERT INTO public.allergen (id, name, number)
VALUES (1, 'Gluten',1),
       (2, 'Crustaceans',2),
       (3, 'Eggs',3),
       (4, 'Fish',4),
       (5, 'Peanuts',5),
       (6, 'Soy',6),
       (7, 'Milk',7),
       (8, 'Nuts',8),
       (9, 'Celery',9),
       (10, 'Mustard',10),
       (11, 'Sesame seeds',11),
       (12, 'Sulphites',12),
       (13, 'Lupin',13),
       (14, 'Molluscs',14),
       (15, 'Dairy',15),
       (16, 'Garlic',16),
       (17, 'Shellfish',17),
       (18, 'Coconut',18);



INSERT INTO public.dish (id, name, description, price)
VALUES (1, 'Bruschetta Pomodoro', 'Grilled bread topped with fresh tomatoes, basil, garlic, and olive oil.', 6.50),
       (2, 'Stuffed Mushrooms', 'Button mushrooms stuffed with garlic, herbs, and cheese.', 7.50),
       (3, 'Caprese Salad', 'Slices of fresh mozzarella, tomatoes, and basil drizzled with balsamic glaze.', 8.00),
       (4, 'Shrimp Cocktail', 'Poached shrimp served with a tangy cocktail sauce.', 9.00),
       (5, 'Spring Rolls', 'Crispy rolls filled with vegetables and served with a sweet chili sauce.', 6.00),
       (6, 'Tomato Basil Soup', 'A creamy blend of tomatoes and basil.', 5.50),
       (7, 'French Onion Soup', 'Caramelized onions in a rich broth topped with a cheese-covered crouton.', 6.50),
       (8, 'Miso Soup', 'Traditional Japanese soup with tofu, seaweed, and scallions.', 4.50),
       (9, 'Chicken Tortilla Soup', 'Spicy chicken soup topped with tortilla strips and avocado.', 7.00),
       (10, 'Clam Chowder', 'Creamy soup with clams, potatoes, and celery.', 8.00),
       (11, 'Caesar Salad', 'Romaine lettuce with Caesar dressing, croutons, and Parmesan cheese.', 7.00),
       (12, 'Greek Salad', 'Mixed greens with feta, olives, cucumbers, tomatoes, and red onions.', 8.00),
       (13, 'Quinoa Salad', 'Quinoa mixed with roasted vegetables and a lemon vinaigrette.', 7.50),
       (14, 'Cobb Salad', 'Mixed greens with chicken, bacon, avocado, egg, and blue cheese.', 9.50),
       (15, 'Asian Chicken Salad', 'Mixed greens with grilled chicken, mandarin oranges, and a sesame dressing.', 8.50),
       (16, 'Spaghetti Carbonara', 'Spaghetti tossed with pancetta, egg, and Parmesan cheese.', 12.00),
       (17, 'Grilled Salmon', 'Grilled salmon fillet with a lemon-dill sauce.', 15.00),
       (18, 'Chicken Alfredo', 'Fettuccine pasta with creamy Alfredo sauce and grilled chicken.', 13.00),
       (19, 'Beef Stroganoff', 'Tender beef in a creamy mushroom sauce served over egg noodles.', 14.00),
       (20, 'Vegetable Stir-Fry', 'Mixed vegetables stir-fried with a savory sauce, served over rice.', 10.00),
       (21, 'Lamb Chops', 'Grilled lamb chops with rosemary and garlic.', 18.00),
       (22, 'Margherita Pizza', 'Classic pizza with tomato sauce, fresh mozzarella, and basil.', 9.00),
       (23, 'Eggplant Parmesan', 'Breaded eggplant slices baked with marinara sauce and mozzarella.', 11.00),
       (24, 'Seafood Paella', 'Traditional Spanish rice dish with a mix of seafood.', 16.00),
       (25, 'Falafel Platter', 'Crispy falafel served with hummus, pita, and a cucumber-tomato salad.', 10.50),
       (26, 'Tiramisu', 'Classic Italian dessert with layers of coffee-soaked ladyfingers and mascarpone.', 6.50),
       (27, 'Chocolate Lava Cake', 'Warm chocolate cake with a gooey center, served with vanilla ice cream.', 7.00),
       (28, 'Cheesecake', 'Creamy cheesecake with a graham cracker crust.', 6.00),
       (29, 'Fruit Tart', 'Pastry crust filled with custard and topped with fresh fruits.', 5.50),
       (30, 'Lemon Sorbet', 'Refreshing lemon sorbet.', 4.00),
       (31, 'Garlic Parmesan Wings', 'Crispy chicken wings tossed in garlic and Parmesan sauce.', 8.50),
       (32, 'Crispy Calamari', 'Lightly breaded calamari rings served with marinara sauce.', 9.50),
       (33, 'Spinach Artichoke Dip', 'Creamy dip made with spinach, artichokes, and cheese, served with pita bread.',
        7.50),
       (34, 'Stuffed Bell Peppers', 'Bell peppers stuffed with rice, beef, and herbs, topped with marinara sauce.',
        8.00),
       (35, 'Hummus Plate', 'Traditional hummus served with pita bread and vegetable sticks.', 6.50),
       (36, 'Butternut Squash Soup', 'Velvety butternut squash soup with a hint of nutmeg.', 5.50),
       (37, 'Lentil Soup', 'Hearty lentil soup with vegetables and spices.', 5.00),
       (38, 'Gazpacho', 'Cold Spanish tomato-based soup with cucumber and peppers.', 4.50),
       (39, 'Chicken Noodle Soup', 'Classic soup with chicken, noodles, and vegetables.', 6.00),
       (40, 'Potato Leek Soup', 'Creamy soup made with potatoes and leeks.', 5.50),
       (41, 'Waldorf Salad', 'Apples, walnuts, celery, and grapes in a creamy dressing.', 8.00),
       (42, 'Panzanella Salad', 'Tuscan salad with tomatoes, bread, cucumbers, and red onions.', 7.50),
       (43, 'Beet Salad', 'Roasted beets with goat cheese, arugula, and balsamic vinaigrette.', 8.50),
       (44, 'Niçoise Salad', 'Mixed greens with tuna, green beans, potatoes, and olives.', 9.00),
       (45, 'Southwest Chicken Salad', 'Mixed greens with grilled chicken, corn, black beans, and avocado.', 8.50),
       (46, 'Beef Tacos', 'Soft tortillas filled with seasoned beef, lettuce, cheese, and salsa.', 10.00),
       (47, 'Vegetable Lasagna', 'Layers of pasta, vegetables, ricotta, and marinara sauce.', 12.00),
       (48, 'Chicken Parmesan', 'Breaded chicken breast topped with marinara sauce and mozzarella.', 13.50),
       (49, 'Pad Thai', 'Rice noodles stir-fried with shrimp, tofu, peanuts, and a tangy sauce.', 12.50),
       (50, 'Bangers and Mash', 'Traditional British dish with sausages, mashed potatoes, and gravy.', 11.50),
       (51, 'Stuffed Cabbage Rolls', 'Cabbage leaves stuffed with rice and meat, cooked in tomato sauce.', 11.00),
       (52, 'Prawn Risotto', 'Creamy risotto with prawns and a hint of saffron.', 14.50),
       (53, 'Eggplant Moussaka', 'Layers of eggplant, minced meat, and béchamel sauce.', 13.00),
       (54, 'Fish and Chips', 'Beer-battered fish fillet with fries and tartar sauce.', 12.50),
       (55, 'Ratatouille', 'Traditional French vegetable stew.', 10.00),
       (56, 'Apple Pie', 'Classic apple pie with a flaky crust.', 5.00),
       (57, 'Panna Cotta', 'Creamy Italian dessert served with a berry coulis.', 6.00),
       (58, 'Carrot Cake', 'Moist carrot cake with cream cheese frosting.', 5.50),
       (59, 'Mango Sticky Rice', 'Sweet mango served with coconut sticky rice.', 6.50),
       (60, 'Churros', 'Fried dough pastry sprinkled with cinnamon sugar, served with chocolate sauce.', 5.00);


INSERT INTO public.weekly_menu (id, start_date, end_date, week_number, year)
VALUES (1, '2024-09-02', '2024-09-06', 36, 2024),
       (2, '2024-09-09', '2024-09-13', 37, 2024),
       (3, '2024-09-16', '2024-09-20', 38, 2024);

INSERT INTO public.menu_item (id, code, day_index, course_id, dish_id, weekly_menu_id)
VALUES (100, 'S1', 0, 1, 10, 1),
       (101, 'S1', 1, 1, 6, 1),
       (102, 'S1', 2, 1, 7, 1),
       (103, 'S1', 3, 1, 8, 1),
       (104, 'S1', 4, 1, 9, 1),
       (105, 'S2', 0, 1, 36, 1),
       (106, 'S2', 1, 1, 37, 1),
       (107, 'S2', 2, 1, 38, 1),
       (108, 'S2', 3, 1, 39, 1),
       (109, 'S2', 4, 1, 40, 1),
       (110, 'M1', 0, 2, 16, 1),
       (111, 'M1', 1, 2, 17, 1),
       (112, 'M1', 2, 2, 18, 1),
       (113, 'M1', 3, 2, 19, 1),
       (114, 'M1', 4, 2, 20, 1),
       (115, 'M2', 0, 2, 46, 1),
       (116, 'M2', 1, 2, 47, 1),
       (117, 'M2', 2, 2, 48, 1),
       (118, 'M2', 3, 2, 49, 1),
       (119, 'M2', 4, 2, 50, 1),
       (120, 'D1', 0, 3, 26, 1),
       (121, 'D1', 1, 3, 27, 1),
       (122, 'D1', 2, 3, 28, 1),
       (123, 'D1', 3, 3, 29, 1),
       (124, 'D1', 4, 3, 30, 1),
       (125, 'D2', 0, 3, 56, 1),
       (126, 'D2', 1, 3, 57, 1),
       (127, 'D2', 2, 3, 58, 1),
       (128, 'D2', 3, 3, 59, 1),
       (129, 'D2', 4, 3, 60, 1)
       ;

INSERT INTO public.address (id, zip_code, country, settlement, street_and_house_number)
VALUES
    (1, '10001', 'USA', 'New York', '123 Main St Apt 4B'),
    (2, '90001', 'USA', 'Los Angeles', '456 Elm St Unit 5C'),
    (3, '94105', 'USA', 'San Francisco', '789 Pine St Suite 6D'),
    (4, '60601', 'USA', 'Chicago', '101 Maple St Apt 7E'),
    (5, '75201', 'USA', 'Dallas', '202 Oak St Unit 8F'),
    (6, '75111', 'USA', 'Dallas', '10 Oak St Unit 3D');

INSERT INTO public.member (id, username, password, email, public_id, first_name, last_name, phone, address_id)
VALUES
    (1, 'john.doe','$2a$10$mXDB81q7Qs5Gt9EbCtBgrORggHD2vFSaJBlfGOjs9aGT9q.mus7kW','john.doe@example.com','0e2aa3a1-b6cb-428f-91dd-e884aeb16953', 'John', 'Doe', '555-1234', 1),
    (2, 'jane.smith','$2a$10$mXDB81q7Qs5Gt9EbCtBgrORggHD2vFSaJBlfGOjs9aGT9q.mus7kW','jane.smith@example.com','1e2aa3a1-b6cb-428f-91dd-e884aeb16953', 'Jane', 'Smith', '555-5678', 2),
    (3, 'michael.johnson','$2a$10$mXDB81q7Qs5Gt9EbCtBgrORggHD2vFSaJBlfGOjs9aGT9q.mus7kW','michael.johnson@example.com','2e2aa3a1-b6cb-428f-91dd-e884aeb16953', 'Michael', 'Johnson', '555-8765', 3),
    (4, 'emily.davis','$2a$10$mXDB81q7Qs5Gt9EbCtBgrORggHD2vFSaJBlfGOjs9aGT9q.mus7kW','emily.davis@example.com','3e2aa3a1-b6cb-428f-91dd-e884aeb16953', 'Emily', 'Davis', '555-4321', 4),
    (5, 'william.brown','$2a$10$mXDB81q7Qs5Gt9EbCtBgrORggHD2vFSaJBlfGOjs9aGT9q.mus7kW','william.brown@example.com','4e2aa3a1-b6cb-428f-91dd-e884aeb16953', 'William', 'Brown', '555-9876', 5),
    (6, 'admin','$2a$10$mXDB81q7Qs5Gt9EbCtBgrORggHD2vFSaJBlfGOjs9aGT9q.mus7kW','admin@example.com','5e2aa3a1-b6cb-428f-91dd-e884aeb16953', 'The', 'Admin', '555-3333', 6);

INSERT INTO public.member_role (id, role)
VALUES
    (1, 'ROLE_USER'),
    (2, 'ROLE_ADMIN');

INSERT INTO public.members_roles (user_id, role_id)
VALUES
    (1, 1),
    (2, 1),
    (3, 1),
    (4, 1),
    (5, 1),
    (6, 1),
    (6, 2);




