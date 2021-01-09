DELIMITER $
create trigger tri_amountUpdate before update
    on vipInfo for each row
begin
    declare c int;
    declare d int;
#     set c = (select stuCount from class where classID=new.classID);
    set c = (select balance from user where user.username = new.username);
    set d = new.totalAmount-OLD.totalAmount;
    update user set balance = c + d where username = new.username;
    if new.totalAmount>1000 then set  new.viplevel = 7;
    elseif new.totalAmount>800 then set new.viplevel = 6;
    elseif new.totalAmount>600 then set new.viplevel = 5;
    elseif new.totalAmount>400 then set new.viplevel = 4;
    elseif new.totalAmount>300 then set new.viplevel = 3;
    elseif new.totalAmount>200 then set new.viplevel = 2;
    elseif new.totalAmount>200 then set new.viplevel = 1;
    else set NEW.viplevel = 0;
    end if;
end$
DELIMITER ;
# 创建的触发器，实现加钱的时候更改余额和VIP等级