-- Database: nutriHospitalar

-- DROP DATABASE IF EXISTS "nutriHospitalar";

CREATE DATABASE "nutriHospitalar"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

	
--criação de tabelas
--Tabela Usuario
CREATE TABLE Usuario (
    idUsuario SERIAL PRIMARY KEY,
    nome VARCHAR(60) NOT NULL,
    email VARCHAR(60) NOT NULL UNIQUE,
    senha VARCHAR(60) NOT NULL,
    tipoUsuario VARCHAR(60) NOT NULL
);

--Tabela Dieta
CREATE TABLE Dieta (
    idDieta SERIAL PRIMARY KEY,
    tipoDieta VARCHAR(50) NOT NULL
);

--Tabela Deposito
CREATE TABLE Deposito (
    idDeposito SERIAL PRIMARY KEY,
    idDieta int,
   lote varchar (20),
   Fornecedor varchar(40),
    validade VARCHAR(40),
    quantidade INT,
	 conforme BOOLEAN,
	 nomedieta varcha(100),
    FOREIGN KEY (idDieta) REFERENCES Dieta(idDieta)
);
--ALTER TABLE Deposito ADD COLUMN nomeDieta VARCHAR(100);
--ALTER TABLE Deposito DROP CONSTRAINT unique_nomedieta;
ALTER TABLE Deposito
ADD CONSTRAINT unica_lote UNIQUE (lote);




ALTER TABLE Deposito
ALTER COLUMN quantidade TYPE INT USING quantidade::INTEGER;




alter table


--Tabela Paciente
CREATE TABLE Paciente (
    idPaciente SERIAL PRIMARY KEY,
    nomePaciente VARCHAR(40),
    leito VARCHAR(4),
    idDieta int,
	nomedieta VARCHAR(100),
    ala VARCHAR(2),
    FOREIGN KEY (idDieta) REFERENCES Dieta(idDieta)
);
ALTER TABLE Paciente ADD COLUMN nomedieta VARCHAR(100);

--ALTER TABLE Paciente ALTER COLUMN idPaciente SET NOT NULL;
--ALTER TABLE Paciente ALTER COLUMN idPaciente ADD GENERATED ALWAYS AS IDENTITY;

--Tabela Finalizada
CREATE TABLE finalizada (
    idFinalizada SERIAL PRIMARY KEY,
    qualFuncionario VARCHAR(100),
    turno VARCHAR(100),
    status BOOLEAN,
    idPaciente INTEGER,
    idDeposito INTEGER,
    idDieta INTEGER,
    nomePaciente VARCHAR(255),
    leito VARCHAR(255),
    ala VARCHAR(255),
    FOREIGN KEY (idPaciente) REFERENCES Paciente(idPaciente),
    FOREIGN KEY (idDeposito) REFERENCES Deposito(idDeposito),
    FOREIGN KEY (idDieta) REFERENCES Dieta(idDieta)
);
/*ALTER TABLE finalizada
    ALTER COLUMN qualFuncionario TYPE VARCHAR(100),
    ALTER COLUMN turno TYPE VARCHAR(100);*/

--ALTER TABLE finalizada ADD COLUMN nomeDieta VARCHAR(100);
--ALTER TABLE finalizada ALTER COLUMN idFinalizada SET NOT NULL;
--ALTER TABLE finalizada ALTER COLUMN idFinalizada ADD GENERATED ALWAYS AS IDENTITY;


-- fim tabelas


--selects
Select * from Paciente;
Select * from Usuario;
Select * from Dieta;
Select * from Finalizada;
Select * from Deposito;
Select * from InformacaoPacientes;
Select * from InformacaoPacientesFim;
Select * from v_finalizada_deposito ;
--Fim Selects


--views 
/*Mostra infos para a tabela "Deitas entregues do dia" nela informa NOME do paciente, Leito, Dieta, TurnoResponsavel e
Status8*/
CREATE OR REPLACE VIEW InformacaoPacientes AS
SELECT 
    p.nomePaciente AS Nome,
    p.leito AS Leito,
    p.nomeDieta AS Dieta, 
    p.ala AS Ala,
    f.status AS Status
	FROM
    Paciente p
LEFT JOIN 
    Finalizada f ON p.nomePaciente = f.nomePaciente
	--DROP VIEW InformacaoPacientes;
/*
CREATE OR REPLACE VIEW InformacaoPacientes AS
SELECT 
    finalizada.nomePaciente AS Nome,
    finalizada.leito AS Leito,
    finalizada.idDieta AS IdDieta,
    finalizada.status AS Status
FROM 
    finalizada;
	*/

	-- fim view InformacaoPacientes
	
	--view com mais informaçoes de paciente 
	CREATE OR REPLACE VIEW InformacaoPacientesFim AS
SELECT 
    f.idFinalizada AS IdFinalizada,
    f.idDieta AS IdDieta,               -- <-- Campo adicionado
    f.nomePaciente AS Nome,
    f.leito AS Leito,
    d.nomedieta AS NomeDieta, 
    f.ala AS Ala,
    f.turno AS Turno,
    f.qualFuncionario AS QualFuncionario,
    f.status AS Status
FROM 
    finalizada f
JOIN 
    Deposito d ON f.nomeDieta = d.nomedieta;

	/*
CREATE OR REPLACE VIEW InformacaoPacientesFim AS
SELECT 
    finalizada.idFinalizada AS IdFinalizada,
    finalizada.nomePaciente AS Nome,
    finalizada.leito AS Leito,
    finalizada.idDieta AS IdDieta,
    finalizada.ala AS Ala,
    finalizada.turno AS Turno,
    finalizada.qualFuncionario AS QualFuncionario,
    finalizada.status AS Status
FROM 
    finalizada;
*/
--DROP VIEW InformacaoPacientesFim;
	--fim view informcoes passientes
	
	--view para info finalizda completa. Puxando de deposito e finalizadas
CREATE VIEW v_finalizada_deposito AS
SELECT 
    f.idFinalizada,
    f.idDieta,
    f.nomePaciente,
    f.leito,
    f.ala,
    d.quantidade,
    d.validade
FROM 
    finalizada f
JOIN 
    Deposito d ON f.idDeposito = d.idDeposito;




Select * from v_finalizada_deposito;
Select * from InformacaoPacientes;
SELECT idFinalizada, idDieta, nomePaciente, leito, ala, quantidade, validade FROM v_finalizada_deposito;
--fim view finalizada + deposito



/*CREATE VIEW FinalizacaoDetalhada AS
SELECT 
    f.idFinalizada,
    f.qualFuncionario,
    f.turno,
    f.status,
    f.dietaPaciente,
    p.idPaciente,
    p.nomePaciente,
    p.leito,
    p.ala,
    d.idDeposito,
    d.dietaDeposito,
    d.dataRecibo,
    d.conforme,
    d.validade,
    d.quantidade,
  --  u.idUsuario,
    u.nome AS nomeUsuario,
    u.email,
    u.tipoUsuario
FROM 
    finalizada f
JOIN 
    Paciente p ON f.idPaciente = p.idPaciente
JOIN 
    Deposito d ON f.idDeposito = d.idDeposito
JOIN 
    Usuario u ON f.idUsuario = u.idUsuario;*/




--Insertes :
--insert Usuario
/*
INSERT INTO Usuario (idUsuario, nome, email, senha, tipoUsuario) VALUES
(1, 'Alice Silva', 'alice.silva@example.com', 'senha123', 'Nutricionista'),
(2, 'Bruno Lima', 'bruno.lima@example.com', 'senha123', 'Estoquista'),
(3, 'Carla Souza', 'carla.souza@example.com', 'senha123', 'Nutricionista');
--fim insert usuario
--inserts dietas
INSERT INTO Dieta (idDieta, tipoDieta) VALUES
(1, 'SRC123'),
(2, 'Hipossódica'),
(3, 'Vegetariana');


--fim insertes dietas
--insert tabela Deposito 
INSERT INTO Deposito (idDeposito, idDieta, dataRecibo, conforme, validade, quantidade) VALUES
(1, 1, '2025-01-15', TRUE, '2025-06-01', '20 unidades'),
(2, 2, '2025-01-10', FALSE, '2025-05-15', '15 unidades'),
(3, 3, '2025-01-20', TRUE, '2025-06-10', '30 unidades');



--fim insert deposito

--insert Paciente
INSERT INTO Paciente ( nomePaciente, leito, idDieta, ala) VALUES
( 'Daniel Costa', 'A101', 1, 'A1'),
( 'Evelyn Souza', 'A102', 2, 'A1'),
( 'Felipe Marques', 'B201', 3, 'B2');


--fim insert Paciente

--insert finalizada
INSERT INTO finalizada (idFinalizada, qualFuncionario, turno, status, idPaciente, idDeposito, idDieta) VALUES
(1, TRUE, TRUE, FALSE, 1, 1, 1),
(2, FALSE, TRUE, TRUE, 2, 2, 2),
(3, TRUE, FALSE, TRUE, 3, 3, 3);*/
--fim insert finaliza 
--fim inserts


--triggers para nao repetir os dados

--trigger funcionario
CREATE OR REPLACE FUNCTION impedir_duplicidade_usuario()
RETURNS TRIGGER AS $$
BEGIN
    IF EXISTS (SELECT 1 FROM Usuario WHERE idUsuario = NEW.idUsuario OR email = NEW.email) THEN
        RAISE EXCEPTION 'Duplicidade detectada: idUsuario % ou email % já existe.', NEW.idUsuario, NEW.email;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_impedir_duplicidade_usuario
BEFORE INSERT ON Usuario
FOR EACH ROW
EXECUTE FUNCTION impedir_duplicidade_usuario();
--fim funcionario

--trigger deitas
CREATE OR REPLACE FUNCTION impedir_duplicidade_dieta()
RETURNS TRIGGER AS $$
BEGIN
    IF EXISTS (SELECT 1 FROM Dieta WHERE idDieta = NEW.idDieta OR tipoDieta = NEW.tipoDieta) THEN
        RAISE EXCEPTION 'Duplicidade detectada: idDieta % ou tipoDieta % já existe.', NEW.idDieta, NEW.tipoDieta;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_impedir_duplicidade_dieta
BEFORE INSERT ON Dieta
FOR EACH ROW
EXECUTE FUNCTION impedir_duplicidade_dieta();
--fim trigger dieta

--trigger deposito
CREATE OR REPLACE FUNCTION impedir_duplicidade_deposito()
RETURNS TRIGGER AS $$
BEGIN
    IF EXISTS (SELECT 1 FROM Deposito WHERE idDeposito = NEW.idDeposito) THEN
        RAISE EXCEPTION 'Duplicidade detectada: idDeposito % já existe.', NEW.idDeposito;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_impedir_duplicidade_deposito
BEFORE INSERT ON Deposito
FOR EACH ROW
EXECUTE FUNCTION impedir_duplicidade_deposito();

--fim trigger deposito

--trigger pacinte 
CREATE OR REPLACE FUNCTION impedir_duplicidade_paciente2()
RETURNS TRIGGER AS $$
BEGIN
    IF EXISTS (SELECT 1 FROM Paciente WHERE nomePaciente = NEW.nomePaciente) THEN
        RAISE EXCEPTION 'Duplicidade detectada: Paciente % já existe.', NEW.nomePaciente;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER verificar_duplicidade_paciente
BEFORE INSERT ON Paciente
FOR EACH ROW
EXECUTE FUNCTION impedir_duplicidade_paciente2();

--fim trigger paciente

--trigger finalizada
CREATE OR REPLACE FUNCTION impedir_duplicidade_finalizada()
RETURNS TRIGGER AS $$
BEGIN
    IF EXISTS (SELECT 1 FROM finalizada WHERE idFinalizada = NEW.idFinalizada) THEN
        RAISE EXCEPTION 'Duplicidade detectada: idFinalizada % já existe.', NEW.idFinalizada;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_impedir_duplicidade_finalizada
BEFORE INSERT ON finalizada
FOR EACH ROW
EXECUTE FUNCTION impedir_duplicidade_finalizada();
---------------------------------------------------------------------------
--Impedir Quantidade Negativa ou Zero no Depósito
CREATE OR REPLACE FUNCTION impedir_quantidade_invalida()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.quantidade IS NULL OR NEW.quantidade <= 0 THEN
        RAISE EXCEPTION 'Quantidade inválida: deve ser maior que zero.';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_impedir_quantidade_invalida
BEFORE INSERT OR UPDATE ON Deposito
FOR EACH ROW
EXECUTE FUNCTION impedir_quantidade_invalida();

------------------------------------------------------------

--Validar Formato de Email em Usuario
--Garante que o campo email tenha um formato básico válido.
CREATE OR REPLACE FUNCTION validar_email()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.email !~ '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$' THEN
        RAISE EXCEPTION 'Formato de email inválido: %', NEW.email;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_validar_email
BEFORE INSERT OR UPDATE ON Usuario
FOR EACH ROW
EXECUTE FUNCTION validar_email();
----------------------------------------------------------------------------
-- Evitar Datas de Validade Expiradas em Deposito
-- Não tenho a coluna tipo DATE.
ALTER TABLE Deposito ALTER COLUMN validade TYPE DATE USING validade::DATE;

CREATE OR REPLACE FUNCTION impedir_validade_vencida()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.validade < CURRENT_DATE THEN
        RAISE EXCEPTION 'Produto com validade vencida (%).', NEW.validade;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
--
CREATE TRIGGER trigger_impedir_validade_vencida
BEFORE INSERT OR UPDATE ON Deposito
FOR EACH ROW
EXECUTE FUNCTION impedir_validade_vencida();

-------------------------------------------------------------------------------
--drops cuidado
/*drop table Paciente;
drop table Finalizada;
DROP VIEW InformacaoPacientes;
DROP VIEW InformacaoPacientesFim;
DROP TABLE IF EXISTS finalizada;
DROP TABLE IF EXISTS Paciente;
DROP TABLE IF EXISTS Deposito;
DROP TABLE IF EXISTS Usuario;
DROP TABLE IF EXISTS Dieta;*/
--fim drops


	