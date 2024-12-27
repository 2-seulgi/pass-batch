-- 기본 데이터베이스 문자셋 설정
ALTER DATABASE pass_local CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- 테이블 주석을 명시적으로 추가
ALTER TABLE `package` COMMENT '패키지';
ALTER TABLE `pass` COMMENT '이용권';
ALTER TABLE `booking` COMMENT '예약';
ALTER TABLE `user` COMMENT '사용자';
