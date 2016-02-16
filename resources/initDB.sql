insert address
(address_id, address_line1,address_line2,landmark,city,zip_code,state,country,created_by,created_date,updated_by,updated_date,record_version_no, deleted_yn)
values
(1, 'address_line1', 'address_line2', 'landmark', 'city', '687543','state', 'country', 1, NOW(), 1, NOW(), 0, 0);

insert party
(party_id, first_name, middle_name, last_name, email, home_phone_number, business_phone_number, cell_phone_number, address_id, gender, date_of_birth,created_by,created_date,updated_by,updated_date,record_version_no, deleted_yn)
values
(1, 'first_name', 'middle_name', 'last_name', 'email','789098765', '123456789','123456789', 1, 'M', NOW(), 1, NOW(), 1, NOW(), 0, 0);

insert user 
(user_id, party_id, status, locale_code, reward_points, subscribed_for_news_letter_yn, created_by, created_date, updated_by, updated_date, record_version_no, deleted_yn) 
values 
(1, 1, 'NEW', 'en_US', 0, 0, 1, NOW(), 1, NOW(), 0, 0);



