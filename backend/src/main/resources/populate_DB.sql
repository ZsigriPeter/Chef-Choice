INSERT INTO public.course_type (id, name)
VALUES (1, 'SOUP'),
       (2, 'MAIN'),
       (3, 'DESSERT');

INSERT INTO public.allergen (id, name)
VALUES (1, 'Gluten'),
       (2, 'Crustaceans'),
       (3, 'Eggs'),
       (4, 'Fish'),
       (5, 'Peanuts'),
       (6, 'Soybeans'),
       (7, 'Milk'),
       (8, 'Nuts'),
       (9, 'Celery'),
       (10, 'Mustard'),
       (11, 'Sesame seeds'),
       (12, 'Sulphites'),
       (13, 'Lupin'),
       (14, 'Molluscs');

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
       (30, 'Lemon Sorbet', 'Refreshing lemon sorbet.', 4.00);

INSERT INTO public.weekly_menu (id, start_date, end_date, week_number, year)
VALUES (1, '2024-07-22', '2024-07-26', 30, 2024),
       (2, '2024-07-29', '2024-08-02', 30, 2024),
       (3, '2024-08-05', '2024-08-09', 30, 2024);



